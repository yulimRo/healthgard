package com.healthgard.server.web.dto;

import com.healthgard.server.domain.trainer.Trainer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TrainerUpdateRequestDto{
	
	private String name;
	private String dept;

	@Builder
	public TrainerUpdateRequestDto(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	public Trainer toEntity() {
		return Trainer.builder()
				.name(this.name)
				.dept(this.dept).build();
	}
	
	
	
}
