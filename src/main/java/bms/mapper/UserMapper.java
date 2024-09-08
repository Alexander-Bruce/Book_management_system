package bms.mapper;

import bms.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public int deleteUser(int id);
    public int updateUser(User user);
    public User getUser(int id);
    public List<User> getAllUsers();
}
