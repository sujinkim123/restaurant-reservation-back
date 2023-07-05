package com.sujinkim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class TestContoller {

	@GetMapping("/test")
	public String test() {
		System.out.println("테스트 성공!");
		return "테스트 API 입니다.";
	}

}
