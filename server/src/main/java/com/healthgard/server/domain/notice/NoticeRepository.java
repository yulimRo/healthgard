package com.healthgard.server.domain.notice;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Notice Entity Repository
 */
public interface NoticeRepository extends JpaRepository<Notice,Long>, PagingAndSortingRepository<Notice,Long> {
}
