package com.healthgard.server.web.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.healthgard.server.domain.trainer.Trainer;
import com.healthgard.server.domain.trainer.TrainerRepository;
import com.healthgard.server.web.dto.TrainerListResponseDto;
import com.healthgard.server.web.dto.TrainerRegistRequestDto;
import com.healthgard.server.web.dto.TrainerUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrainerService {
	
	private final TrainerRepository trainerRepository;
	
	public List<TrainerListResponseDto> findAllDesc() {
		
		List<TrainerListResponseDto> trainers = trainerRepository.findAllDesc().stream().map(TrainerListResponseDto::new).collect(Collectors.toList());
				
		return trainers;
	}
	
	public TrainerListResponseDto getTrainerById(Long id) {

		Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회되는 트레이너가 없습니다."));
		
		TrainerListResponseDto resDto = new TrainerListResponseDto(trainer);
		
		return resDto;
	}

	@Transactional
	public Long registTrainer(TrainerRegistRequestDto reqDto) {
		
		Trainer newTrainer = reqDto.toEntity();
		trainerRepository.save(newTrainer);
		
		return newTrainer.getId();
	}
	
	@Transactional
	public Long updateTrainer(Long id, TrainerUpdateRequestDto reqDto) {
		
		Trainer prev = trainerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회되는 트레이너가 없습니다."));
		
		if(prev != null) {
			prev.update(reqDto.getName(),reqDto.getDept());
		}
		
		return id;
	}
	
	@Transactional
	public Long removeTrainer(Long id) {
		Trainer prev = trainerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("조회되는 트레이너가 없습니다."));
		trainerRepository.delete(prev);		
		return id;
	}

}
