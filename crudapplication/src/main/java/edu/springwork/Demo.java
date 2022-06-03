package edu.springwork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	@GetMapping("/testing")
	public String job() {
		return "<body bgcolor='red' text='yellow'><h1>I am Amitava</h1></body>";
	}

}
