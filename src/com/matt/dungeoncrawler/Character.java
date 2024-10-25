package com.matt.dungeoncrawler;

abstract class Character {
	String name;
	int health;
	
	public Character(String name, int health) {
		this.name = name;
		this.health = health;
	};
	
	public void attack() {
		System.out.println(name + "is attacking!");
	};
	
	public abstract void displayStats();
};
