package encounters;

import java.util.Scanner;
import com.matt.dungeoncrawler.Character;

public abstract class Encounter {
    public abstract void startEncounter(Character playerCharacter, Scanner scanner);
    
    public void endEncounter(Character playerCharacter, Scanner scanner) {
        System.out.println("Encounter complete.\n");
        playerCharacter.changeGear(scanner);
    }
}