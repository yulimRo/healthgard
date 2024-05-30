package com.healthgard.server.domain.trainer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.healthgard.server.domain.common.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Trainer extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String dept;

	@Builder
	public Trainer(Long id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	public Long update(String name, String dept) {
		this.name = name;
		this.dept = dept;
		
		return id;
	}
}
