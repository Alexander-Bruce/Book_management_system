package bms.controller;

import bms.domain.ResponseBody;
import bms.domain.User;
import bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user/register")
    public ResponseBody register(@RequestBody User user) {

         if(userService.getUser(user) == null) {
            userService.addUser(user);

            return ResponseBody.success(
                    200,
                    "success",
                    user
            );
        }

        return ResponseBody.error(
                400,
                "user already exists",
                null
        );
    }

    @PostMapping("user/login")
    public ResponseBody login(@RequestBody User user) {
        User targetUser = userService.getUser(user);

        if (targetUser == null) {
            return ResponseBody.error(
                    404,
                    "User does not exist. Please sign up first."
            );
        }

        String token = userService.userTokenValidation(user);

        if (token == null) {
            return ResponseBody.error(
                    400,
                    "Incorrect password.",
                    token
            );
        }

        return ResponseBody.success(
                200,
                "Login success",
                token
        );
    }

    @GetMapping("user/profile")
    public ResponseBody userProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            return ResponseBody.success(
                    200,
                    "Upload profile success",
                    user
            );
        }

        return ResponseBody.error(
                400,
                "Can't load profile"
        );

    }

    @PostMapping("user/delete")
    public ResponseBody delete(User user) {
        User targetUser = userService.getUser(user);


        if(targetUser != null && userService.userAuthorization(user, targetUser)){
            return ResponseBody.success(
                    200,
                    "success",
                    userService.deleteUser(user.getId())
            );
        }

        return ResponseBody.error(
                400,
                "user does not exist",
                null
        );
    }

    @PostMapping("user/update")
    public ResponseBody update(User user) {
        User targetUser = userService.getUser(user);

        if (targetUser != null && userService.userAuthorization(user, targetUser)) {
            userService.updateUser(user);
            return ResponseBody.success(
                    200,
                    "success",
                    null
            );
        }

        return ResponseBody.error(
                400,
                "user does not exist",
                null
        );
    }

    @PostMapping("user/admin/userlist")
    public ResponseBody getUserList() {

        return ResponseBody.success(
                200,
                "success",
                userService.getAllUsers()
        );
    }

   @PostMapping("user/self")
   public ResponseBody getUser(User user) {

        return ResponseBody.success(
                200,
                "success",
                userService.getUser(user)
        );
   }
}
