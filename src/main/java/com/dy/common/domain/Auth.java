package com.dy.common.domain;

public enum Auth {

	G("GUEST"),
	M("MEMBER"),
	A("ADMIN");

	private String role;

	Auth(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}
