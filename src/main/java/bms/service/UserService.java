package bms.service;


import bms.domain.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int deleteUser(int id);
    public int updateUser(User user);
    public User getUser(int id);
    public List<User> getAllUsers();
}
