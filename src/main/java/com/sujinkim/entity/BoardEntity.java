package com.sujinkim.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="board")
@Entity
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_id;

	private Long category_id;

	private String title;

	private String contents;

	private String writer;

	private LocalDateTime created_at;

	private LocalDateTime updated_at;


}
