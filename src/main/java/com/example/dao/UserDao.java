/**
 * 
 */
package com.example.dao;

import com.example.entity.User;
import com.mindtree.exceptions.DaoException;

/**
 * @author M1030608
 *
 */
public interface UserDao {
	
	public boolean insertUser(User user) throws DaoException;

}
