package bms.controller;

import bms.domain.Result;
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
    public Result register(User user) {
        if(userService.getUser(user) != null) {
            return Result.success(
                    200,
                    "success",
                    userService.addUser(user)
            );
        }
        return Result.error(
                400,
                "user already exists",
                null
        );
    }

    @GetMapping("user/delete")
    public Result delete(User user) {
        if(userService.getUser(user) != null){
            return Result.success(
                    200,
                    "success",
                    userService.deleteUser(user.getId())
            );
        }
        return Result.error(
                400,
                "user does not exist",
                null
        );
    }

    @GetMapping("user/update")
    public Result update(User user) {
        if (userService.getUser(user) != null) {
            userService.updateUser(user);
            return Result.success(
                    200,
                    "success",
                    null
            );
        }
        return Result.error(
                400,
                "user does not exist",
                null
        );
    }

    @GetMapping("user/admin/userlist")
    public Result getUserList() {
        return Result.success(
                200,
                "success",
                userService.getAllUsers()
        );
    }

   @GetMapping("user/self")
   public Result getUser(User user) {
        return Result.success(
                200,
                "success",
                userService.getUser(user)
        );
   }
}
