package bms.mapper;

import bms.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Mapper
public interface UserMapper {
    // @Transactional
    public int addUser(User user);

    @Transactional
    public int deleteUser(int id);

    // @Transactional
    public int updateUser(User user);

    @Transactional
    public User getUser(User user);

    @Transactional
    public List<User> getAllUsers();
}
