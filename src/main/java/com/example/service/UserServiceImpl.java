/**
 * 
 */
package com.example.service;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.entity.User;
import com.mindtree.exceptions.DaoException;
import com.mindtree.exceptions.ServiceException;

/**
 * @author M1030608
 *
 */
public class UserServiceImpl implements UserService {

	UserDao dao;

	/**
	 * 
	 */
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public Boolean insertUser(User user) throws ServiceException {
		try {
			return dao.insertUser(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
