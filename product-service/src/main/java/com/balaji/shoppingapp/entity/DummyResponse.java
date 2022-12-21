package com.balaji.shoppingapp.entity;

import java.util.List;

public class DummyResponse {
	private String name;
	private String message;
	private List<String> role;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DummyResponse() {
	}

	public DummyResponse(String name, String message, List<String> role, String email) {
		super();
		this.name = name;
		this.message = message;
		this.role = role;
		this.email = email;
	}

}
