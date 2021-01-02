package com.LoanManagementSystem.Service.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.LoanManagementSystem.Dao.UserDao;
import com.LoanManagementSystem.Dao.Impl.UserDaoImpl;
import com.LoanManagementSystem.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;
	static int LOG_COLUMN = 0;
	public static final String EMPTY_ROW = "Empty row";

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Object AddUser(MultipartFile file) throws Exception {
		InputStream in = file.getInputStream();
		int ch = 0;
		String fileLocation = null;
		String pathToFile = "D:\\userfile";
		new File(pathToFile).mkdirs();
		fileLocation = pathToFile.substring(0, pathToFile.length()) + "-" + (new Date()).getTime() + "-"
				+ file.getOriginalFilename();
		FileOutputStream fout = new FileOutputStream(fileLocation);
		byte[] bytes = new byte[1024];
		while ((ch = in.read(bytes)) != -1) {
			fout.write(bytes, 0, ch);
		}
		fout.flush();
		fout.close();
		FileInputStream file2 = new FileInputStream(new File(fileLocation));
		XSSFWorkbook workbook = new XSSFWorkbook(file2);
		XSSFSheet workingSheet = workbook.getSheetAt(0);
		int rowCount = 0;
		XSSFRow row = workingSheet.getRow(rowCount);
		int i = 0;
		String[] headerArray = fetchRowFromWorkingSheet(workingSheet, rowCount++);

		if (headerArray != null && workingSheet.getLastRowNum() < 1) {
			throw new Exception("No Records, only Header in file");
		}
		int total = 0;
		String[] dataArray;
		do {
			total++;
			dataArray = fetchRowFromWorkingSheet(workingSheet, rowCount++);
			if (dataArray[0].equalsIgnoreCase(EMPTY_ROW)) {
				break;
			}
			if (dataArray[0].equalsIgnoreCase("Nothing to insert")) {
				break;
			}
			if (dataArray[0].equalsIgnoreCase(" ") || (dataArray[0].trim().length() == 0)) {
				break;
			}
			if (dataArray.length < 1) {
				break;
			}
			String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
			if(!dataArray[1].matches(EMAIL_REGEX)) {
				throw new Exception("please Enter correct Email ");
			}
			userDaoImpl.AddUser(dataArray);
		} while (null != dataArray[0] && !dataArray[0].isEmpty());
		return null;
	}

	String[] fetchRowFromWorkingSheet(XSSFSheet workingSheet, int rowCount) {

		System.out.println("==========" + rowCount);
		XSSFRow row = workingSheet.getRow(rowCount);
		int i = 0;
		String[] dataArray = null;

		XSSFCell cell;
		try {
			cell = row.getCell(i) != null ? row.getCell(i++) : null;
		} catch (Exception e) {
			cell = null;
			return new String[] { "Nothing to insert" };
		}
		List<String> list = new LinkedList<>();
		for (i = rowCount; i < rowCount + 1; i++) {
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					list.add("White Space");
				} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
					list.add(cell.getRawValue());
				} else if (getCellValueAsString(cell).equalsIgnoreCase("")) {
					list.add("White Space");
				} else {
					list.add(getCellValueAsString(cell));
				}
				i++;
			}
		}
		if (rowCount == 0) {
			cell = row.createCell(--i);
			LOG_COLUMN = i;
			cell.setCellValue("UPLOADING_RESULT");
		}
		dataArray = new String[list.size()];
		dataArray = list.toArray(dataArray);
		return dataArray;
	}

	@SuppressWarnings("deprecation")
	public static String getCellValueAsString(Cell cell) {
		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			}
		}
		return strCellValue;
	}

}
