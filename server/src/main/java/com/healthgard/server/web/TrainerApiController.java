package com.healthgard.server.web;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthgard.server.web.dto.TrainerListResponseDto;
import com.healthgard.server.web.dto.TrainerRegistRequestDto;
import com.healthgard.server.web.dto.TrainerUpdateRequestDto;
import com.healthgard.server.web.service.TrainerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trainer")
public class TrainerApiController {

	private final TrainerService trainerService;
	
	@PostMapping("")
	public Long registTrainer (@RequestBody TrainerRegistRequestDto requestDto) {
		Long newId = trainerService.registTrainer(requestDto);
		return newId;
	}
	
	@GetMapping("/{id}")
	public TrainerListResponseDto getTrainerInfo (@PathVariable Long id) {
		TrainerListResponseDto trainer = trainerService.getTrainerById(id);
		return trainer;
	}
	
	@PostMapping("/{id}")
	public Long updateTrainer (@RequestBody TrainerUpdateRequestDto requestDto, @PathVariable Long id) {
		Long updateId = trainerService.updateTrainer(id, requestDto);
		return updateId;
	}
	
	@DeleteMapping("/{id}")
	public Long deleteTrainer (@PathVariable Long id) {
		Long removeId = trainerService.removeTrainer(id);
		return removeId;
	}
}
