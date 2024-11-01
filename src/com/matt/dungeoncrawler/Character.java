package com.matt.dungeoncrawler;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {
	String name;
    int health;
    ArrayList<Gear> weapons;
    ArrayList<Gear> armour;
    int equippedWeaponIndex;
    Gear equippedArmour;
    protected int baseDamage;  // Changed dmg to baseDamage and made it protected
    boolean weaponEquipped = false;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.weapons = new ArrayList<>();
        this.armour = new ArrayList<>();
        this.equippedWeaponIndex = -1;
        this.equippedArmour = null;
        this.baseDamage = 0;  // Initialize base damage
    }
    
    public Gear getEquippedWeapon() {
    	if (equippedWeaponIndex == -1) {
    		return null;
    	}
        return weapons.get(equippedWeaponIndex);
    }

    public void attack() {
        System.out.println(name + " is attacking!");
    };

    public void increaseHealth(int amount) {
        health += amount;
        System.out.println("You rest and gain " + amount + " health. Total health: " + health + "\n");
    };

    public void addWeapon(Gear weapon) {
        weapons.add(weapon);
        weaponEquipped = true;
    };
    
    public void equipWeapon(Gear weapon) {
    	this.equippedWeaponIndex = weapons.indexOf(weapon);
    }

    public void addArmour(Gear armourPiece) {
        armour.add(armourPiece);
    };
    
    public void equipArmour(Gear armourPiece) {
    	this.equippedArmour = armourPiece;
    }

    public abstract void displayStats();

    public int getTotalAttack() {
        int totalDamage = baseDamage;  // Start with base damage
        if (equippedWeaponIndex != -1) {
            totalDamage += getEquippedWeapon().getAttackBonus();  // Add weapon damage
        }
        return totalDamage;
    }

    public int getTotalDefense() {
        if (equippedArmour != null) {
        	return equippedArmour.getDefenseBonus();
        }
        return 0;
    };
    
    public void changeGear(Scanner scanner) {
        System.out.println("Would you like to change any of your equipped gear? y/n");
        String choice = scanner.nextLine();
        if (!choice.equalsIgnoreCase("y")) {
            System.out.println("You decide to keep your equipped gear");
            return;
        }
        
        System.out.println("Select gear type to change:");
        System.out.println("1 - Weapon");
        System.out.println("2 - Armour");
        int gearType = scanner.nextInt();
        scanner.nextLine();
        
        if (gearType == 1) {
            if (weapons.isEmpty()) {
                System.out.println("You have no weapons in your inventory to switch to!");
                return;
            }

            System.out.println("Current weapons in inventory:");
            for(int i = 0; i < weapons.size(); i++) {
                System.out.println((i+1) + ": " + weapons.get(i).getName() + " (Attack: " + weapons.get(i).getAttackBonus() + ")");
            }
            
            if (getEquippedWeapon() != null) {
                System.out.println("\nCurrently equipped: " + getEquippedWeapon().getName() + " (Attack: " + getEquippedWeapon().getAttackBonus() + ")");
            }
            
            System.out.println("\nChoose weapon to equip (enter number):");
            int weaponChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (weaponChoice > 0 && weaponChoice <= weapons.size()) {
                // Equip the new weapon
                equipWeapon(weapons.get(weaponChoice -1));
                
                System.out.println("\nYou equipped the " + getEquippedWeapon().getName());
                displayStats();
            } else {
                System.out.println("Invalid weapon choice!");
            }
        } else if (gearType == 2) {
            System.out.println("Current armour:");
            for(int i = 0; i < armour.size(); i++) {
                System.out.println((i+1) + ": " + armour.get(i).getName() + " (Defense: " + armour.get(i).getDefenseBonus() + ")");
            }
        }
    }
    
    public void endEncounter(Character playerCharacter, Scanner scanner) {
    	System.out.println("Encounter complete.");
    	playerCharacter.changeGear(scanner);
    }
}

