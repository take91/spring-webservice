package com.take.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.take.spring.dto.PostsSaveRequestDto;
import com.take.spring.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@PostMapping("/posts")
	public Long savaPosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
}
