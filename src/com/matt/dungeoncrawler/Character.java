package com.matt.dungeoncrawler;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {
	String name;
    int health;
    ArrayList<Gear> weapons;
    ArrayList<Gear> armour;
    Gear equippedWeapon;
    Gear equippedArmour;
    protected int baseDamage;  // Changed dmg to baseDamage and made it protected
    boolean weaponEquipped = false;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.weapons = new ArrayList<>();
        this.armour = new ArrayList<>();
        this.equippedWeapon = null;
        this.equippedArmour = null;
        this.baseDamage = 0;  // Initialize base damage
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
    	this.equippedWeapon = weapon;
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
        if (equippedWeapon != null) {
            totalDamage += equippedWeapon.getAttackBonus();  // Add weapon damage
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
            // First add currently equipped weapon back to the list if there is one
            if (equippedWeapon != null && !weapons.contains(equippedWeapon)) {
                weapons.add(equippedWeapon);
            }
            
            System.out.println("Current weapons in inventory:");
            for(int i = 0; i < weapons.size(); i++) {
                System.out.println((i+1) + ": " + weapons.get(i).getName() + " (Attack: " + weapons.get(i).getAttackBonus() + ")");
            }
            
            // Show currently equipped weapon if there is one
            if (equippedWeapon != null) {
                System.out.println("\nCurrently equipped: " + equippedWeapon.getName() + " (Attack: " + equippedWeapon.getAttackBonus() + ")");
            }
            
            System.out.println("\nChoose weapon to equip (enter number):");
            int weaponChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (weaponChoice > 0 && weaponChoice <= weapons.size()) {
                // Get the weapon they want to equip
                Gear weaponToEquip = weapons.get(weaponChoice - 1);
                
                // Remove the chosen weapon from the inventory and equip it
                weapons.remove(weaponChoice - 1);
                equipWeapon(weaponToEquip);
                
                System.out.println("\nYou equipped the " + weaponToEquip.getName());
                displayStats();
            } else {
                System.out.println("Invalid weapon choice!");
            }
        } else {
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

