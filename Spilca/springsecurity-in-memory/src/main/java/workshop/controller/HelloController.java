package workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/greet")
	public String sayHello() {
		return "Welcome to Spring Security v3 !!!";
	}
}
