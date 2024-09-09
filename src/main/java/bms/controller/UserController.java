package bms.controller;

import bms.domain.User;
import bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user/register")
    public void register(User user) {
        userService.addUser(user);
    }

    @GetMapping("user/delete")
    public void delete(User user) {
        userService.deleteUser(user.getId());
    }

    @GetMapping("user/update")
    public void update(User user) {
        userService.updateUser(user);
    }

    @GetMapping("user/admin/userlist")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

   @GetMapping("user/self")
   public User getUser(User user) {
        return userService.getUser(user.getId());
   }
}
