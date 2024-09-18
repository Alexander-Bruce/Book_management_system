package bms.config.security.provider;

import bms.config.security.model.UserPrincipal;
import bms.config.security.service.UserDetailsServiceImpl;
import bms.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("CustomAuthenticationProvider.authenticate called");
		// UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		//
		// Integer id = userPrincipal.getUser().getId(); // 可以是用户名、邮箱或其他标识
		// String password = userPrincipal.getPassword();

		User user = User.builder().id(1).build();
		UserPrincipal targetUser = userDetailsServiceImpl.loadUserById(1);
		System.out.println(user);

		String targetPassword = passwordEncoder.encode(targetUser.getPassword());
		// 验证密码
		if (passwordEncoder.matches("Heqinglin2021", targetPassword)) {
			// 认证成功，返回已认证的令牌
			UserDetails userDetails = new UserPrincipal(targetUser.getUser());
			return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
					userDetails.getAuthorities());
		}
		else {
			// 认证失败，抛出异常
			throw new BadCredentialsException("Invalid identifier or password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// 该 AuthenticationProvider 处理 UsernamePasswordAuthenticationToken 类型的认证请求
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
