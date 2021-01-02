package com.LoanManagementSystem.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserService {

	Object AddUser(MultipartFile user) throws IOException, Exception;

}
