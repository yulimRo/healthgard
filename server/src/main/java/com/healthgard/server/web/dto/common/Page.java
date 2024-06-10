package com.healthgard.server.web.dto.common;

import lombok.Getter;

@Getter
public abstract class Page {

	private int pageNum;
	private int amount;
	private int totalCnt;
}
