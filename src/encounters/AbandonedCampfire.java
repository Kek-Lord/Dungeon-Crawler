package encounters;

import com.matt.dungeoncrawler.Character;
import com.matt.dungeoncrawler.Gear;

import java.util.Scanner;

public class AbandonedCampfire extends Encounter {
	@Override
	public void startEncounter(Character playerCharacter, Scanner scanner) {
        System.out.println("\nYou stumble upon a dimly lit burning campfire surrounded by scattered supplies");

        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("1 - SEARCH: search the campsite for supplies");
            System.out.println("2 - REST: recover health, but risk a nearby ambush");
            System.out.println("3 - PUT OUT: Extinguish the fire to prevent enemies from being drawn to the light\n");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice < 1 || choice > 3) {
                    System.out.println("Choice must be between 1 - 3 inclusive. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next(); // Consume the invalid input
            }
        }

        // Use a switch expression to handle the choice
        switch (choice) {
            case 1 -> searchCamp(playerCharacter, scanner);
            case 2 -> playerCharacter.increaseHealth(10);
            case 3 -> System.out.println("You carefully put out the fire, ensuring that no one will find the camp soon.\n");
        }
    }
	
	public void searchCamp(Character player, Scanner scanner) {
	    int randomInt = (int) (Math.random() * 5) + 1; // Generate a random number between 1-5 inclusive
	    Gear foundWeapon = null;

	    switch (randomInt) {
	        case 1 -> foundWeapon = new Gear("Iron Sword", 10, 0);
	        case 2 -> foundWeapon = new Gear("Steel Axe", 15, 0);
	        case 3 -> foundWeapon = new Gear("Magic Staff", 8, 5);
	        case 4 -> foundWeapon = new Gear("Dagger", 5, 1);
	        case 5 -> System.out.println("You search the camp, but find nothing useful.");
	    }

	    if (foundWeapon != null) {
	        System.out.println("You found a " + foundWeapon.getName() + " at the camp!\n");
	        System.out.println(foundWeapon.getStats());
	        System.out.print("\nWould you like to equip it? y/n: ");
	        
	        // Read user's choice to equip or not
	        scanner.nextLine(); // Consume leftover newline from previous input
	        String choice = scanner.nextLine();

	        if (choice.equalsIgnoreCase("y")) {
	            player.addWeapon(foundWeapon);
	            System.out.println("You have equipped the " + foundWeapon.getName() + "!\n");
	        } else {
	            System.out.println("You decide not to equip the " + foundWeapon.getName() + ", and left it behind.");
	        }
	    }
	}


	
}
