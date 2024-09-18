package bms.controller;

import bms.utils.StatusCode;
import bms.config.security.model.UserPrincipal;
import bms.domain.ResponseBody;
import bms.domain.User;
import bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// user/register
	@PostMapping("user/register")
	public ResponseBody register(@RequestBody @Validated User user) {

		if (userService.getUser(user) == null) {
			userService.addUser(user);

			return ResponseBody.success(StatusCode.OK, "Success", user);
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "user already exists", null);
	}

	// user login
	@PostMapping("user/login")
	public ResponseBody login(@RequestBody @Validated User user) {
		User targetUser = userService.getUser(user);

		if (targetUser == null) {
			return ResponseBody.error(StatusCode.NOT_FOUND, "User does not exist. Please sign up first.");
		}

		String token = userService.userTokenValidation(user);

		if (token == null) {
			return ResponseBody.error(StatusCode.BAD_REQUEST, "Incorrect password.");
		}

		return ResponseBody.success(StatusCode.OK, "Login success", token);
	}

	// get user's profile
	@GetMapping("user")
	public ResponseBody userProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			User user = ((UserPrincipal) authentication.getPrincipal()).getUser();
			return ResponseBody.success(StatusCode.OK, "Upload profile success", user);
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "Can't load profile");

	}

	// delete user's data
	@DeleteMapping("user")
	public ResponseBody deleteUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			User user = ((UserPrincipal) authentication.getPrincipal()).getUser();
			return ResponseBody.success(StatusCode.OK, "Delete user's account success",
					userService.deleteUser(user.getId()));
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "user does not exist");
	}

	// update user's data
	@PutMapping("user")
	public ResponseBody updateUser(@RequestBody @Validated User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			User targetUser = ((UserPrincipal) authentication.getPrincipal()).getUser();
			if (userService.updateUser(targetUser, user)) {
				return ResponseBody.success(StatusCode.OK, "Update user's account success");
			}
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot modify user");

	}

	// update user's image
	@PutMapping("user/image")
	public ResponseBody updateUserImage(@RequestBody @Validated User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			User targetUser = ((UserPrincipal) authentication.getPrincipal()).getUser();
			if (userService.updateUser(targetUser, user)) {
				return ResponseBody.success(StatusCode.OK, "Update user's image success");
			}
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot modify user's image");
	}

	@PutMapping("user/password")
	public ResponseBody updateUserPassword(@RequestBody @Validated User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
			if (StringUtils.hasLength(user.getPassword())
					&& user.getPassword().equals(userService.getUser(user).getPassword())) {
				User targetUser = ((UserPrincipal) authentication.getPrincipal()).getUser();
				if (userService.updateUser(targetUser, user)) {
					return ResponseBody.success(StatusCode.OK, "Update user's image success");
				}
			}
			else {
				return ResponseBody.error(StatusCode.CONFLICT,
						"User's password does not match or new password is empty");
			}
		}

		return ResponseBody.error(StatusCode.BAD_REQUEST, "Cannot modify user's image");

	}

	// get all user
	@PostMapping("user/admin/userlist")
	public ResponseBody getUserList() {

		return ResponseBody.success(StatusCode.OK, "Success", userService.getAllUsers());
	}

}
