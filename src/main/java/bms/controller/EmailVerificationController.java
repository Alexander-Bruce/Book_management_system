package bms.controller;

import bms.config.security.service.EmailVerificationService;
import bms.domain.ResponseBody;
import bms.domain.User;
import bms.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
public class EmailVerificationController {

	@Autowired
	private EmailVerificationService emailVerificationService;

	@GetMapping("verify")
	public ModelAndView verifyEmail(@RequestParam("token") String token) {
		try {
			token = URLDecoder.decode(token, StandardCharsets.UTF_8);
		}
		catch (Exception e) {
			e.printStackTrace();
			ModelAndView errorView = new ModelAndView("failure");
			errorView.addObject("message", "Token decoding error!");
			return errorView;
		}

		if (emailVerificationService.verifyToken(token)) {
			// Verification successful, return success page
			ModelAndView successView = new ModelAndView("success");
			successView.addObject("message", "Email successfully verified! You can now close this page.");
			return successView;
		}
		else {
			// Verification failed, return failure page
			ModelAndView errorView = new ModelAndView("failure");
			errorView.addObject("message", "Invalid email verification token!");
			return errorView;
		}
	}

	@GetMapping("verify/resend")
	@org.springframework.web.bind.annotation.ResponseBody
	public ResponseBody resendEmail(@RequestBody User user) throws Exception {
		emailVerificationService.sendVerificationEmail(user.getUsername(), user.getEmail());
		return ResponseBody.error(StatusCode.OK, "Successfully resend email!");
	}

}
