package com.matt.dungeoncrawler;

import java.util.ArrayList;

public abstract class Character {
    String name;
    int health;
    ArrayList<Gear> weapons;
    ArrayList<Gear> armour;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.weapons = new ArrayList<>();
        this.armour = new ArrayList<>();
    }

    public void attack() {
        System.out.println(name + " is attacking!");
    }

    public void increaseHealth(int amount) {
        health += amount;
        System.out.println("You rest and gain " + amount + " health. Total health: " + health + "\n");
    }

    public void addWeapon(Gear weapon) {
        weapons.add(weapon);
    }

    public void addArmour(Gear armourPiece) {
        armour.add(armourPiece);
    }

    public abstract void displayStats();

    public int getTotalAttack() {
        int totalAttack = 0;
        for (Gear weapon : weapons) {
            totalAttack += weapon.getAttackBonus();
        }
        return totalAttack;
    }

    public int getTotalDefense() {
        int totalDefense = 0;
        for (Gear armourPiece : armour) {
            totalDefense += armourPiece.getDefenseBonus();
        }
        return totalDefense;
    }
}

