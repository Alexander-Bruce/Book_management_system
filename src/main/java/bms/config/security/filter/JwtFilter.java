package bms.config.security.filter;

import bms.utils.StatusCode;
import bms.config.security.service.JWTService;
import bms.config.security.service.UserDetailsServiceImpl;
import bms.domain.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;

	@Autowired
	ApplicationContext context;

	@Value("${mode}")
	private String MODE;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		String username = null;

		if (MODE.equals("DEV")) {
			username = "Bush";
			token = jwtService.generateToken(username);
		}
		else if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			try {
				username = jwtService.extractUserName(token);
			}
			catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.setContentType("application/json");
				response.getWriter()
					.write(new ObjectMapper()
						.writeValueAsString(ResponseBody.error(StatusCode.UNAUTHORIZED, e.getMessage())));
				return;
			}
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = context.getBean(UserDetailsServiceImpl.class).loadUserByUsername(username);

			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		filterChain.doFilter(request, response);
	}

}
