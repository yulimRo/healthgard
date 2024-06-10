package com.healthgard.server.web;

import com.healthgard.server.web.dto.notice.NoticeListWithTotalCntResponseDto;
import com.healthgard.server.web.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notice")
public class NoticeApiController {

	private final NoticeService noticeService;
//
//	@PostMapping("")
//	public Long registTrainer (@RequestBody TrainerRegistRequestDto requestDto) {
//		Long newId = trainerService.registTrainer(requestDto);
//		return newId;
//	}
//
//	@GetMapping("/{id}")
//	public TrainerListResponseDto getTrainerInfo (@PathVariable Long id) {
//		TrainerListResponseDto trainer = trainerService.getTrainerById(id);
//		return trainer;
//	}
//
//	@PostMapping("/{id}")
//	public Long updateTrainer (@RequestBody TrainerUpdateRequestDto requestDto, @PathVariable Long id) {
//		Long updateId = trainerService.updateTrainer(id, requestDto);
//		return updateId;
//	}
//
//	@DeleteMapping("/{id}")
//	public Long deleteTrainer (@PathVariable Long id) {
//		Long removeId = trainerService.removeTrainer(id);
//		return removeId;
//	}

	@GetMapping("/noticeList")
	public NoticeListWithTotalCntResponseDto getNoticeList (Pageable pageable) {
		NoticeListWithTotalCntResponseDto noticeList = noticeService.getNoticeListWithPagingAndSort(pageable);
		return noticeList;
	}

	@GetMapping("/registNotice")
	public void registNotice () {
		noticeService.saveNoticeList();
	}

}
