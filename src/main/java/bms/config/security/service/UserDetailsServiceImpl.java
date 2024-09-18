package bms.config.security.service;

import bms.config.security.model.UserPrincipal;
import bms.domain.User;
import bms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUser(User.builder().username(username).build());

		if (user == null)
			throw new UsernameNotFoundException("User not found");

		return new UserPrincipal(user);
	}

	public UserPrincipal loadUserById(Integer id) {
		User user = userMapper.getUser(User.builder().id(id).build());

		if (user == null)
			throw new UsernameNotFoundException("User not found");

		return new UserPrincipal(user);
	}

}
