package bms.service;

import bms.domain.User;

import java.util.List;

public interface UserService {

	int addUser(User user);

	int deleteUser(int id);

	boolean updateUser(User targetUser, User user);

	User getUser(User usr);

	List<User> getAllUsers();

	boolean userAuthorization(User user, User targetUser);

	String userTokenValidation(User user);

	Integer updateUserPassword(User targetUser, User user);

}
