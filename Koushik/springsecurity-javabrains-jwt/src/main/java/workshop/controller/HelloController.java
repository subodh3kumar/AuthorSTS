package workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import workshop.model.AuthenticationRequest;
import workshop.model.AuthenticationResponse;
import workshop.service.JwtUtil;
import workshop.service.MyUserDetailsService;

@RestController
public class HelloController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World !!!";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails=userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
	}
}
