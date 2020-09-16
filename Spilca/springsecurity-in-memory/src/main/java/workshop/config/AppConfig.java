package workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@SuppressWarnings("deprecation")
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsService = new InMemoryUserDetailsManager();
		var user = User.withUsername("user")
				.password("user@2020")
				.authorities("read")
				.roles("user")
				.build();
		userDetailsService.createUser(user);
		return userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
