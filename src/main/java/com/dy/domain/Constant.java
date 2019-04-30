package com.dy.domain;

public class Constant {

	/*
	 * 승인 여부, 사용 여부 등
	 */
	public enum YesNo {
		Y, N;
	}

	/*
	 * 성공, 실패 여부
	 */
	public enum Result {
		OK, FAIL,
	}

	/*
	 * 테이블 리스트
	 */
	public enum Table {
		TB_BOARD("board");

		private String tableName;

		private Table(String tableName) {
			this.tableName = tableName;
		}

		public String getTableName() {
			return tableName;
		}
	}

}
