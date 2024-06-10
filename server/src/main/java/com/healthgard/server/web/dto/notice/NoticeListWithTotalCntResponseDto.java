package com.healthgard.server.web.dto.notice;

import com.healthgard.server.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class NoticeListWithTotalCntResponseDto{
    private long totalCnt;

    private List<NoticeListResponseDto> noticeList;

    @Builder
    public NoticeListWithTotalCntResponseDto(long totalCnt, List<NoticeListResponseDto> entityList) {
        this.totalCnt = totalCnt;
        this.noticeList = entityList;
    }
}
