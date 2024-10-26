package encounters;

import com.matt.dungeoncrawler.Character;
import java.util.Scanner;

public class RoomOfTraps extends Encounter {
	public void startEncounter(Character playerCharacter, Scanner scanner) {
		System.out.println("roomOfTraps");
		System.out.println("You stumble across a corridor, lined with pressure plates and arrow holes in the walls");
		System.out.println("1 - DISARM: Attempt to deactivate the traps with a puzzle or skill check");
		System.out.println("2 - DASH THROUGH: Rush through, avoiding some traps but taking minor damage");
		System.out.println("3 - BACKTRACK: Take an alternative path, but avoid all traps");
	
	}
}
