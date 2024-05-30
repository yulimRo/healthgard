package com.healthgard.server.web.dto;

import java.time.format.DateTimeFormatter;

import com.healthgard.server.domain.trainer.Trainer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TrainerListResponseDto{

	private Long id;
	
	private String name;
	
	private String dept;
	
	private String createDate;
	
	private String updateDate;
	
	public TrainerListResponseDto (Trainer entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.dept = entity.getDept();
		this.createDate = entity.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		this.updateDate = entity.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
	}
	
}
