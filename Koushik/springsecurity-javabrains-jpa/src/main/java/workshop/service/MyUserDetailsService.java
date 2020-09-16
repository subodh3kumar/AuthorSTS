package workshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import workshop.model.MyUserDetails;
import workshop.model.User;
import workshop.repository.UserRepository;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username {}", username);
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));
		log.info("user: {}", user);
		return user.map(MyUserDetails::new).get();
	}
}
