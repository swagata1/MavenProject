package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.entity.User;
import com.example.util.DBUtil;
import com.mindtree.exceptions.DBUtilityException;
import com.mindtree.exceptions.DaoException;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertUser(User user) throws DaoException {
		boolean result = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		} catch (DBUtilityException e) {
			throw new DaoException(e);
		}
		String sql = "insert into users values('" + user.getUsername() + "','" + user.getPassword() + "')";
		System.out.println(sql);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			result = true;
			return result;
		} catch (SQLException e) {
			throw new DaoException(e);
		}

		
	}

}
