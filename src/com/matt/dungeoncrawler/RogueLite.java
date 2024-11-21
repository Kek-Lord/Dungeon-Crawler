package com.matt.dungeoncrawler;

import encounters.*;
import java.util.Scanner;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RogueLite {

    // Class-level variables
    private static Character playerCharacter;
    private static Scanner scanner = new Scanner(System.in); // Use a single Scanner instance

    public static void main(String[] args) {
        boolean endRun = false;
        displayWelcomeMessage(); // Welcome message
        chooseClass();           // Choose class
        displayBreakLine();
        createCharacter();       // Create character
        displayBreakLine();
        enterDungeon();          // Enter the dungeon
        displayBreakLine();

        while (!endRun) {
            choosePath();
            encounter();
        }

        // Close the scanner at the end of the program
        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the dungeon crawler!\n");
        System.out.println("Choose a class!\n1 - Barbarian\n2 - Ranger\n3 - Wizard");
    }

    private static void chooseClass() {
        int chosenClass = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over from nextInt()

        switch (chosenClass) {
            case 1:
                System.out.println("\nYou chose the Barbarian!");
                break;
            case 2:
                System.out.println("\nYou chose the Ranger!");
                break;
            case 3:
                System.out.println("\nYou chose the Wizard!");
                break;
            default:
                System.out.println("\nInvalid choice, please choose a class by using a number between 1-3!");
                break;
        }
    }

    private static void createCharacter() {
        System.out.println("Enter Character Name:\n");
        String name = scanner.nextLine();

        playerCharacter = new Barbarian(name, 10, 8); // create a new Barbarian class to
                                                      // the playerCharacter class variable

        playerCharacter.displayStats(); // Display the character's stats
    }

    private static void enterDungeon() {
        System.out.println("\nYou enter the dungeon...\n");
    }

    private static void displayPathImage(int chosenPath) {
        String filename;

        // Determine the filename based on chosenPath
        switch (chosenPath) {
            case 1:
                filename = "assets/images/hallway.txt";
                break;
            case 2:
                filename = "assets/images/hallway2.txt"; // Add your second path image here
                break;
            case 3:
                filename = "assets/images/hallway3.txt"; // Add your third path image here
                break;
            default:
                System.out.println("Invalid path chosen.");
                return; // Exit the method if an invalid path is chosen
        }

        // Attempt to read and display the image
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void choosePath() {
    	int intValue = (int) (Math.random() * 3) + 1;

        switch (intValue) {
        case 1 -> {
            displayPathImage(intValue);
            System.out.println("\nGo down the hallway?");
            System.out.println("1 - Yes\n2 - No (you go down anyway lol");
            String input = scanner.nextLine();
            // Handle input if necessary
        }
        case 2 -> {
            displayPathImage(intValue);
            System.out.println("\nYou see two paths. One going left, another going right");
            System.out.println("1 - Take the left path\n2 - Take the right path");
            int input = scanner.nextInt();
            scanner.nextLine(); // Consume newline if more inputs follow
            // Handle input if necessary
        }
        case 3 -> {
            System.out.println("\nYou see three paths. One to a shop, one to the left, and one to the right");
            int input = scanner.nextInt();
            scanner.nextLine(); // Consume newline if more inputs follow
            // Handle input if necessary
        }
    }
}

    private static void encounter() {
        Encounter encounter = selectEncounter();
        if (encounter != null) {
            encounter.startEncounter(playerCharacter, scanner);
            encounter.endEncounter(playerCharacter, scanner);
        }
    }

    private static Encounter selectEncounter() {
        int encounterNum = (int) (Math.random() * 8) + 1;

        return switch (encounterNum) {
            case 1 -> new GoblinPartyAmbush();
            case 2 -> new SkeletonCrypt();
            case 3 -> new Necromancer();
            case 4 -> new GoblinMiners();
            case 5 -> new AbandonedCampfire();
            case 6 -> new CursedTreasureChest();
            case 7 -> new RoomOfTraps();
            case 8 -> new AltarOfSacrifice();
            default -> null;
        };
    }
    
    public static void displayBreakLine() {
    	System.out.println("----------------------------------------------------------------------------------");
    }
}
