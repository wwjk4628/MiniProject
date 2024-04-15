package com.java.mini.copy;

public class Mini {
	private String name;
	private String phone;
	private String hp;

	public Mini(String name, String phone, String hp) {
		this.name = name;
		this.phone = phone;
		this.hp = hp;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
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

	@Override
	public String toString() {
		int a = 1;
		return a++ + " " + name + " " + phone + " " + hp;

	}
}
