package com.sujinkim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujinkim.dto.BoardDto;
import com.sujinkim.service.BoardService;

@RestController
@RequestMapping(value="/api")
public class TestContoller {

	@Autowired
	BoardService boardService;


	@GetMapping("/test")
	public String test() {
		System.out.println("테스트 성공!");
		return "테스트 API 입니다.";
	}

	@GetMapping("/board/list")
	@CrossOrigin
	public List<BoardDto> boardList() {
		return boardService.getBoardList();
	}

	@GetMapping("/board/{id}")
	@CrossOrigin
	public BoardDto getBoard(@PathVariable Long id) {
		return boardService.getBoard(id);
	}

}
