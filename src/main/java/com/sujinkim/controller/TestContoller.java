package com.sujinkim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujinkim.dto.BoardDto;
import com.sujinkim.pagination.Header;
import com.sujinkim.service.BoardService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:3001")
public class TestContoller {

	@Autowired
	BoardService boardService;


	@GetMapping("/test")
	public String test() {
		System.out.println("테스트 성공!");
		return "테스트 API 입니다.";
	}

	@GetMapping("/board/list")
	public Header<List<BoardDto>> boardList(@PageableDefault(size = 10, sort= {"boardId"}) Pageable pageable) {
		System.out.println("호출");
		System.out.println(">>>>>>> " + boardService.getBoardList(pageable));
		return boardService.getBoardList(pageable);
	}

	@GetMapping("/board/{id}")
	public BoardDto getBoard(@PathVariable Long id) {
		return boardService.getBoard(id);
	}

}
