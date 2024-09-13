package bms.service;


import bms.domain.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int deleteUser(int id);
    public boolean updateUser(User targetUser, User user);
    public User getUser(User usr);
    public List<User> getAllUsers();
    public boolean userAuthorization(User user, User targetUser);
    public String userTokenValidation(User user);
}
