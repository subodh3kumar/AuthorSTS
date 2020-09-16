package workshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import workshop.entity.UserEntity;
import workshop.model.User;
import workshop.repository.UserRepository;

public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<UserEntity> findByUsername = userRepository.findByUsername(username);
		UserEntity entity = findByUsername.orElseThrow(() -> new UsernameNotFoundException("Username not available"));
		User user = convert(entity);
		return new UserSecurity(user);
	}

	private User convert(UserEntity entity) {
		User user = new User();
		user.setId(entity.getId());
		user.setUsername(entity.getUsername());
		user.setPassword(entity.getPassword());
		return user;
	}
}
