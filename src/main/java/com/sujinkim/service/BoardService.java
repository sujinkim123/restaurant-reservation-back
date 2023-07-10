package com.sujinkim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujinkim.dto.BoardDto;
import com.sujinkim.entity.BoardEntity;
import com.sujinkim.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	public List<BoardDto> getBoardList() {

		List<BoardEntity> boardEntities = boardRepository.findAll();
		List<BoardDto> dtos = new ArrayList<>();

		for(BoardEntity entity : boardEntities) {
			BoardDto dto = BoardDto.builder()
					.idx(entity.getBoard_id())
					.writer(entity.getWriter())
					.title(entity.getTitle())
					.contents(entity.getContents())
					.createdAt(entity.getCreated_at())
					.build();

			dtos.add(dto);
		}

		System.out.println(">> 확인 : " + dtos.toString());
		return dtos;
	}

	public BoardDto getBoard(Long id) {
		BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		return BoardDto.builder()
				.idx(entity.getBoard_id())
				.title(entity.getTitle())
				.contents(entity.getContents())
				.writer(entity.getWriter())
				.createdAt(entity.getCreated_at())
				.build();
	}

}
