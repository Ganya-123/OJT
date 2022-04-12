package com.main.first.dto;

public class UserResponseDto {
	private Long user_id;
	private String full_name;
	private String user_name;
	private String date_of_birth;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	@Override
	public String toString() {
		return "UserResponseDto [user_id=" + user_id + ", full_name=" + full_name + ", user_name=" + user_name
				+ ", date_of_birth=" + date_of_birth + "]";
	}

}
