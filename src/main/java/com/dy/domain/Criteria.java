package com.dy.domain;

public class Criteria {

	/** 현재 페이지 번호 */
	private int currentPage;

	/** 페이지마다 출력할 행의 개수 */
	private int perPageRow;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage < 1) {
			this.currentPage = 1;
			return;
		}
		this.currentPage = currentPage;
	}

	public int getPerPageRow() {
		return perPageRow;
	}

	public void setPerPageRow(int perPageRow) {
		if (perPageRow < 1 || perPageRow > 500) {
			perPageRow = 10;
			return;
		}
		this.perPageRow = perPageRow;
	}

}
