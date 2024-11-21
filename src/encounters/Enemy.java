package encounters;

import com.matt.dungeoncrawler.Character;

public class Enemy {
    public String name;
    public int health;
    int damage;
    
    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    
    public void takeTurn(Character playerCharacter, Enemy enemy) {
    	displayStats();
        System.out.println("\nThe " + name + " lunges out and attacks!\n");
        System.out.println("You take " + damage + " damage!");
        playerCharacter.health -= damage;
        System.out.println(playerCharacter.health);
    }
    
    public void displayStats() {
    	System.out.println("\n" + name);
    	System.out.println(health + " health");
    	System.out.println(damage + " attack");
    }
    
    public int getHealth() {
    	return health;
    }
}
