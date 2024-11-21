package com.matt.dungeoncrawler;
import java.util.Scanner;
import encounters.*;

public class Barbarian extends Character {
    public Barbarian(String name, int health, int dmg) {
        super(name, health);
        this.baseDamage = dmg;  // Set the base damage from parent class
    }
	
	@Override
	public void takeTurn(Scanner scanner, Character playerCharacter, Enemy enemy) {
		System.out.println("Choose action: ");
		System.out.println("1 - Attack with equipped weapon: " + playerCharacter.getTotalAttack() + " damage");
		System.out.println("2 - Drink a health potion: +5 health");
		int choice = scanner.nextInt();
		if (choice == 1) {
			enemy.health -= playerCharacter.getTotalAttack();
			System.out.println("\nYou attack the " + enemy.name + " and deal " + playerCharacter.getTotalAttack() + " damage");
		} else {
			System.out.println("You drink a health potion and restore 5 health");
			playerCharacter.health +=5;
		}
	}
	
	public void displayStats() {
        System.out.println("\nName: " + name);
        System.out.println("Health: " + health);
        System.out.println("Base Damage: " + baseDamage);
        System.out.println("Total Damage: " + getTotalAttack());
        if (getEquippedWeapon() != null) {
            System.out.println("Equipped Weapon: " + getEquippedWeapon().getName()+ 
                             " (+" + getEquippedWeapon().getAttackBonus() + " damage)");
        }
    }

}
