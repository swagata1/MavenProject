/**
 * 
 */
package com.example.service;

import com.example.entity.User;
import com.mindtree.exceptions.ServiceException;

/**
 * @author M1030608
 *
 */
public interface UserService {
	
	public Boolean insertUser(User user) throws ServiceException;

}
