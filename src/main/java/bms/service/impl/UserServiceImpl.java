package bms.service.impl;

import bms.config.security.service.JWTService;
import bms.domain.User;
import bms.mapper.UserMapper;
import bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Override
    public int addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
        return userMapper.getUser(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    @Override
    public boolean userAuthorization(User user, User targetUser){
        return passwordEncoder.matches(user.getPassword(), targetUser.getPassword());
    }

    @Override
    public String userTokenValidation(User user) throws BadCredentialsException{
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user);

        return null;
    }
}
