package com.healthgard.server.web.service;


import com.healthgard.server.domain.notice.Notice;
import com.healthgard.server.domain.notice.NoticeRepository;
import com.healthgard.server.web.dto.TrainerListResponseDto;
import com.healthgard.server.web.dto.notice.NoticeListResponseDto;
import com.healthgard.server.web.dto.notice.NoticeListWithTotalCntResponseDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeListWithTotalCntResponseDto getNoticeListWithPagingAndSort(Pageable pageable){
        Page<Notice> entityList = noticeRepository.findAll(pageable);
        List<NoticeListResponseDto> noticeList = entityList.getContent().stream().map(NoticeListResponseDto::new).collect(Collectors.toList());

        NoticeListWithTotalCntResponseDto responseDto = NoticeListWithTotalCntResponseDto.builder().entityList(noticeList).totalCnt(entityList.getTotalElements()).build();

        return responseDto;

    }

    @Transactional
    public void saveNoticeList(){
        for(int i =0; i < 123; i++){
            Notice notice = Notice.builder().title("타이틀"+i).content("내용"+i).build();
            noticeRepository.save(notice);
        }
    }
}
