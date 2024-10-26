package com.matt.dungeoncrawler;

public class Gear {
	
	private String name;
	private int attackBonus;
	private int defenseBonus;
	
	public Gear(String name, int attackBonus, int defenseBonus) {
		this.name = name;
		this.attackBonus = attackBonus;
		this.defenseBonus = defenseBonus;
	}
	
	public String getStats() {
		return "Name: " + name + "\nAttack: " + attackBonus + "\nDefense: " + defenseBonus;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAttackBonus() {
		return attackBonus;
	}
	
	public int getDefenseBonus() {
		return defenseBonus;
	}
}
