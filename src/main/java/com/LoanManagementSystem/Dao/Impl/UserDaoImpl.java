package com.LoanManagementSystem.Dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.LoanManagementSystem.Dao.UserDao;
import com.LoanManagementSystem.Models.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Object findAlll(int id) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		if ((0 != id)) {
			criteria.add(Restrictions.eq("user_id", id));
		}
		return criteria.list();
	}

	@Override
	public void AddUser(String[] dataArray) {

		Session session = entityManager.unwrap(Session.class);
		User user = new User();
		user.setName(dataArray[0]);
		user.setEmail(dataArray[1]);
		user.setPhone(dataArray[2]);
		user.setOveralllimit(dataArray[3]);
		user.setUtilizedlimit(dataArray[4]);
		user.setAvailablelimit(dataArray[5]);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
