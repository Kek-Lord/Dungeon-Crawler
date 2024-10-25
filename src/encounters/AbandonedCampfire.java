package encounters;

public class AbandonedCampfire extends Encounter{
	public void startEncounter() {
		System.out.println("You stumble upon a dimly lit burning campfire surrounded by scattered supplies");
		System.out.println("1 - SEARCH: search the campsite for supplies");
		System.out.println("2 - REST: recover health, but risk a nearby ambush");
		System.out.println("3 - PUT OUT: Extinguish the fire to prevent enemies from being drawn to the light");
	}
}
