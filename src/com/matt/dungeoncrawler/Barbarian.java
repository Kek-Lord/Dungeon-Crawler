package com.matt.dungeoncrawler;

public class Barbarian extends Character {
    public Barbarian(String name, int health, int dmg) {
        super(name, health);
        this.baseDamage = dmg;  // Set the base damage from parent class
    }
	
	@Override
	public void attack() {
		System.out.println(name + "uses strength to attack!");
	}
	
	public void displayStats() {
        System.out.println("\nName: " + name);
        System.out.println("Health: " + health);
        System.out.println("Base Damage: " + baseDamage);
        System.out.println("Total Damage: " + getTotalAttack());
        if (equippedWeapon != null) {
            System.out.println("Equipped Weapon: " + equippedWeapon.getName() + 
                             " (+" + equippedWeapon.getAttackBonus() + " damage)");
        }
    }
}
