package com.sujinkim.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {

	private Long idx;

	private Long categoryId;

	private String categoryName;

	private String title;

	private String contents;

	private String writer;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

}
