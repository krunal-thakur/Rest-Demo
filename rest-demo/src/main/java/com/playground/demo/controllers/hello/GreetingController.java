package com.playground.demo.controllers.hello;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playground.demo.response.GreetingResponse;

@RestController
public class GreetingController {
	
	
	@RequestMapping(path="/greeting", produces=MediaType.APPLICATION_JSON_VALUE)
	public GreetingResponse greeting(@RequestParam(value="name", defaultValue="Guest") String name) {
		return new GreetingResponse(name);
	}

}
