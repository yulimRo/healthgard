package com.healthgard.server.domain.notice;

import com.healthgard.server.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Notice extends BaseEntity {

    @Id
    @Column(name="notice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Builder
    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
