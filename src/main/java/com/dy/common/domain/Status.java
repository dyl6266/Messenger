package com.dy.common.domain;

public enum Status {

	Y("1", true), /* Y, "1", true가 한 묶음이 된 상태 */
	N("0", false); /* N, "0", false가 한 묶음이 된 상태 */

	private String firstValue;
	private boolean secondValue;

	Status(String firstValue, boolean secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public boolean isSecondValue() {
		return secondValue;
	}

}
