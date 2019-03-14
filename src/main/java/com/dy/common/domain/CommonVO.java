package com.dy.common.domain;

import java.util.Date;

public class CommonVO {

	/* 상태 */
	private YesNo status;

	/* 등록일 */
	private Date insertTime;

	/* 수정일 */
	private Date updateTime;

	public YesNo getStatus() {
		return status;
	}

	public void setStatus(YesNo status) {
		this.status = status;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
