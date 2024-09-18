package bms.mapper;

import bms.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper {

	@Transactional
	int addUser(User user);

	@Transactional
	int deleteUser(int id);

	@Transactional
	boolean updateUser(User targetUser, User user);

	@Transactional
	User getUser(User user);

	@Transactional
	List<User> getAllUsers();

}
