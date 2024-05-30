package com.healthgard.server.web.dto;

import com.healthgard.server.domain.trainer.Trainer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TrainerRegistRequestDto{

	private String name;
	
	private String dept;

	@Builder
	public TrainerRegistRequestDto(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public Trainer toEntity() {
		return Trainer.builder()
				.name(this.name)
				.dept(this.dept).build();
	}
	
	
	
}
