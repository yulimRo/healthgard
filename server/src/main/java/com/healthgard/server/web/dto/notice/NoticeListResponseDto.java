package com.healthgard.server.web.dto.notice;

import com.healthgard.server.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
public class NoticeListResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime updateDate;

    @Builder
    public NoticeListResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.updateDate = entity.getUpdateDate();
    }
}
