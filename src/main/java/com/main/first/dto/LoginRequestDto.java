package com.main.first.dto;

public class LoginRequestDto {
	private Long user_id;
	private String password;

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDto [user_id=" + user_id + ", password=" + password + "]";
	}

}
