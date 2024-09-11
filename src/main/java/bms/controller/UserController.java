package bms.controller;

import bms.domain.Result;
import bms.domain.User;
import bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("user/register")
    public Result register(@RequestBody User user) {

         if(userService.getUser(user) == null) {
            userService.addUser(user);

            return Result.success(
                    200,
                    "success",
                    user
            );
        }

        return Result.error(
                400,
                "user already exists",
                null
        );
    }

    @PostMapping("user/login")
    public Result login(@RequestBody User user) {
        User targetUser = userService.getUser(user);

        if (targetUser == null) {
            return Result.error(
                    404,
                    "User does not exist. Please sign up first."
            );
        }


        if (!userService.userAuthorization(user)) {
            return Result.error(
                    400,
                    "Incorrect password."
            );
        }

        return Result.success(
                200,
                "Login success"
        );
    }

    @GetMapping("user/delete")
    public Result delete(User user) {
        user = userService.getUser(user);


        if(user != null && userService.userAuthorization(user)){
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
        user = userService.getUser(user);

        if (user != null && userService.userAuthorization(user)) {
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
