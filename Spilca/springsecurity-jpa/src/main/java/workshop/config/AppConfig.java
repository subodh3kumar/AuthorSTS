package workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import workshop.service.JpaUserDetailsService;

@Configuration
@SuppressWarnings("deprecation")
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new JpaUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
