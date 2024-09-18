package bms.controller;

import bms.config.security.service.EmailVerificationService;
import bms.domain.ResponseBody;
import bms.domain.User;
import bms.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
public class EmailVerificationController {

	@Autowired
	private EmailVerificationService emailVerificationService;

	@GetMapping("verify")
	public ResponseBody verifyEmail(@RequestParam("token") String token) {
		try {
			token = URLDecoder.decode(token, StandardCharsets.UTF_8.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseBody.error(StatusCode.BAD_REQUEST, "Token decoding error!");
		}

		if (emailVerificationService.verifyToken(token)) {
			return ResponseBody.success(StatusCode.OK, "Successfully verified email!");
		}
		else {
			return ResponseBody.error(StatusCode.BAD_REQUEST, "Invalid email verification token!");
		}
	}

	@GetMapping("verify/resend")
	public ResponseBody resendEmail(@RequestBody User user) throws Exception {
		emailVerificationService.sendVerificationEmail(user.getUsername(), user.getEmail());
		return ResponseBody.error(StatusCode.OK, "Successfully resend email!");
	}

}
