package encounters;

import com.matt.dungeoncrawler.Character;
import java.util.Scanner;

public class CursedTreasureChest extends Encounter{
	public void startEncounter(Character playerCharacter, Scanner scanner) {
		System.out.println("A glint of gold catches your eye in a dusty chest, but the air feels heavy and forboding");
		System.out.println("1 - OPEN CAREFULLY: Discover a valuable item but risk triggering a curse (e.g., reduced attack or defense temporarily");
		System.out.println("2 - BREAK LOCK: use your strength to break the lock, and open the chest");
		System.out.println("3 - LEAVE IT: Gain some experience, but miss the potential rewards");
	}
}
