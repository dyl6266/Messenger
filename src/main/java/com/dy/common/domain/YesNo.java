package com.dy.common.domain;

public enum YesNo {
	/* 사용 여부, 승인 여부 등 */
	Y(true), N(false);

	private boolean flag;

	YesNo(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

}
