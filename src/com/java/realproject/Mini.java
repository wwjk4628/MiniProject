package com.java.realproject;

public class Mini {
	private String name;
	private String ph;
	private String hp;

	public Mini() {

	}

	public Mini(String name, String ph, String hp) {
		this.name = name;
		this.ph = ph;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void draw() {
		System.out.printf(" %s %s %s", name, ph, hp);
	}

	@Override
	public String toString() {

		return name + "," + ph + "," + hp;
	}

}
