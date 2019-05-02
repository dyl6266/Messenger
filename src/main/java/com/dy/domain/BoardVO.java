package com.dy.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dy.common.domain.YesNo;

public class BoardVO {

	/** PK */
	@Min(value = 1)
	private Integer idx;

	/** 제목 */
	@NotBlank(message = "제목을 입력해 주세요.")
	@Size(max = 30, message = "제목을 30자 이내로 입력해 주세요.")
	private String title;

	/** 내용 */
	@NotBlank(message = "내용을 입력해 주세요.")
	@Size(max = 2000, message = "내용을 2000자 이내로 입력해 주세요.")
	private String content;

	/** 작성자 */
	@NotBlank(message = "작성자를 입력해 주세요.")
	private String writer;

	/** 사용 여부 */
	private YesNo useYn;

	/** 공지글 여부 */
	private YesNo noticeYn;

	/** 비밀글 여부 */
	private String secretYn;

	/** 등록일 */
	private Date insertTime;

	/** 수정일 */
	private Date updateTime;

	/** 조회수 */
	private int viewCnt;

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		if (idx == null || idx < 1) {
			this.idx = 1;
			return;
		}
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public YesNo getUseYn() {
		return useYn;
	}

	public void setUseYn(YesNo useYn) {
		this.useYn = useYn;
	}

	public YesNo getNoticeYn() {
		return noticeYn;
	}

	public void setNoticeYn(YesNo noticeYn) {
		this.noticeYn = noticeYn;
	}

	public String getSecretYn() {
		return secretYn;
	}

	public void setSecretYn(String secretYn) {
		this.secretYn = secretYn;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

}
