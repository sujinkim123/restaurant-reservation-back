package com.sujinkim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sujinkim.dto.BoardDto;
import com.sujinkim.entity.Board;
import com.sujinkim.pagination.Header;
import com.sujinkim.pagination.Pagination;
import com.sujinkim.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;

	public Header<List<BoardDto>> getBoardList(Pageable pageable) {

		List<BoardDto> dtos = new ArrayList<>();

		Page<Board> boardEntities = boardRepository.findAllByOrderByBoardIdDesc(pageable);
		for (Board entity : boardEntities) {
			BoardDto dto = BoardDto.builder()
					.idx(entity.getBoardId())
					.title(entity.getTitle())
					.writer(entity.getWriter())
					.createdAt(entity.getCreatedAt())
					.build();

			dtos.add(dto);
		}

		Pagination pagination = new Pagination(
				(int) boardEntities.getTotalElements(),
				pageable.getPageNumber() + 1,
				pageable.getPageSize(),
				10
		);

		return Header.OK(dtos, pagination);

	}

	public BoardDto getBoard(Long id) {
		Board entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		return BoardDto.builder().idx(entity.getBoardId()).title(entity.getTitle()).contents(entity.getContents())
				.writer(entity.getWriter()).createdAt(entity.getCreatedAt()).build();
	}

}
