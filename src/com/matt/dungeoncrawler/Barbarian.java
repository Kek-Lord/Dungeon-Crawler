package com.matt.dungeoncrawler;

public class Barbarian extends Character {
	int strength;
	
	public Barbarian(String name, int health, int strength) {
		super(name, health);
		this.strength = strength;
	}
	
	@Override
	public void attack() {
		System.out.println(name + "uses strength to attack!");
	}
	
	public void displayStats() {
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Strength: " + strength);
	}
}
