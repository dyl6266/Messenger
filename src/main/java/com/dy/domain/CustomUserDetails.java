package com.dy.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dy.common.domain.Authority;
import com.dy.common.domain.CommonVO;
import com.dy.common.domain.Gender;

@SuppressWarnings("serial")
public class CustomUserDetails extends CommonVO implements UserDetails {

	/* PK */
	private Integer idx;

	/* 아이디 */
	private String email;

	/* 비밀번호 */
	private String password;

	/* 이름 */
	private String name;

	/* 연락처 */
	private String phone;

	/* 성별 */
	private Gender gender;

	/* 권한 */
	private Authority authority;

	/* 원본 파일명 */
	private String originalFilename;

	/* 저장 파일명 */
	private String storedFilename;

	/* 파일 크기 */
	private long fileSize;

	/* 상태 메시지 */
	private String statusMessage;

	/* 회원가입 인증 키 */
	private String key;

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getStoredFilename() {
		return storedFilename;
	}

	public void setStoredFilename(String storedFilename) {
		this.storedFilename = storedFilename;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 계정이 가지고 있는 권한 목록 반환
	 * 
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + Authority.valueOf(authority.getValue())));
		return authorities;
	}

	/**
	 * 계정의 패스워드 반환
	 * 
	 * @return
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * 계정의 아이디 반환
	 * 
	 * @return
	 */
	@Override
	public String getUsername() {
		return email;
	}

	/**
	 * 계정이 만료 되었는지에 대한 여부 반환 (true : 만료되지 않음)
	 * 
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 계정이 잠겨 있는지에 대한 여부 반환 (true : 잠기지 않음)
	 * 
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 패스워드가 만료 되었는지에 대한 여부 반환 (true : 만료되지 않음)
	 * 
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 계정이 활성화(사용 가능) 상태인지에 대한 여부 반환 (true : 활성화)
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		boolean status = true;

		if ("N".equals(getStatus().toString())) {
			status = false;
		}

		return status;
	}

}
