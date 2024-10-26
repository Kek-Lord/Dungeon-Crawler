package encounters;

import com.matt.dungeoncrawler.Character;
import java.util.Scanner;

public class GoblinPartyAmbush extends Encounter {
	@Override
	public void startEncounter(Character playerCharacter, Scanner scanner) {
		System.out.println("goblinPartyAmbush");
	}
}
