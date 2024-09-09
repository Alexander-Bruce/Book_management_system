package bms.service.impl;

import bms.domain.User;
import bms.mapper.UserMapper;
import bms.service.UserService;
import bms.utils.AESUtils;
import bms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user){
        user.setPassword(AESUtils.encode(user.getPassword()));
        user.setUuid(UUIDGenerator.getUuid());
        return userMapper.addUser(user);
    }
    @Override
    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }
    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    @Override
    public User getUser(User user){
        if(user.getPassword() != null)
            user.setPassword(AESUtils.encode(user.getPassword()));
        return userMapper.getUser(user);
    }
    @Override
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
}
