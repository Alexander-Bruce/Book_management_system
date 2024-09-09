package bms.service.impl;

import bms.domain.User;
import bms.mapper.UserMapper;
import bms.service.UserService;
import bms.utils.AES;
import bms.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user){
        user.setPassword(AES.encode(user.getPassword()));
        // user.setUsername(UUIDGenerator.getUuid());
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
            user.setPassword(AES.encode(user.getPassword()));
        return userMapper.getUser(user);
    }
    @Override
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
}
