package com.dy.domain;

public class Pagination {

	private void calculation() {
		int currentPage = criteria.getCurrentPage();
		int perPageRow = criteria.getPerPageRow();

		/*
		 * ex:) 끝 페이지 = 20, 페이지 사이즈 = 10
		 * 
		 * 20 - (10 - 1) = 1
		 */
		startPage = endPage - (pageSize - 1);
		endPage = (int) (Math.ceil(currentPage / pageSize)) * pageSize;
		int tempEndPage = (int) (Math.ceil(totalCnt / perPageRow));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		hasPrevPage = startPage == 1 ? false : true;
		hasNextPage = (perPageRow * endPage) < totalCnt ? false : true;
	}

	/** 전체 데이터 수 */
	private int totalCnt;

	/** 현재 페이지 번호, 페이지마다 출력할 행의 수 */
	private Criteria criteria;

	/** 시작 페이지 번호 */
	private int startPage;

	/** 끝 페이지 번호 */
	private int endPage;

	/** 하단에 출력할 페이지 수 */
	private int pageSize;

	/** 이전 페이지 여부 */
	private boolean hasPrevPage;

	/** 다음 페이지 여부 */
	private boolean hasNextPage;

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

}
