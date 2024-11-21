package encounters;

import java.util.Scanner;
import com.matt.dungeoncrawler.Character;

public abstract class Encounter {

	boolean endCombat = false;

	public abstract void startEncounter(Character playerCharacter, Scanner scanner);

	public void endEncounter(Character playerCharacter, Scanner scanner) {
		System.out.println("Encounter complete.\n");
		playerCharacter.changeGear(scanner);
		System.out.println(playerCharacter.health);
	}

	public void combat(Scanner scanner, Enemy enemy, Character playerCharacter) {
	    while (!endCombat) {
	        enemy.takeTurn(playerCharacter, enemy);
	        
	        if (playerCharacter.health <= 0 || enemy.health <= 0) {
	            endCombat = true;
	        }
	        
	        playerCharacter.takeTurn(scanner, playerCharacter, enemy);
	        
	        if (playerCharacter.health <= 0 || enemy.health <= 0) {
	        	endCombat = true;
	        }
	    }
	}
}