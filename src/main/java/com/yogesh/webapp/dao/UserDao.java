package com.yogesh.webapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.yogesh.webapp.model.User;

public interface UserDao {
	void insertUser(User user) throws SQLException;

	User selectUser(long userId);

	List<User> selectAllUsers();

	boolean deleteUser(long id) throws SQLException;

	void updateUser(User user) throws SQLException;
}
