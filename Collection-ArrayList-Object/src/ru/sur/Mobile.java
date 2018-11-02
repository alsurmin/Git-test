package ru.sur;

public class Mobile {
	private int number;
	private String name;
	
	public Mobile(int number, String name) {
		this.name = name;
		this.number = number;		
		
	}
	
	public int getNamber() {
		return number;
	}
	public void setNamber(int namber) {
		this.number = namber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
