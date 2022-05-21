package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.PossibleBattles;
import main.Player;

import org.junit.jupiter.api.Test;

class PossibleBattlesTest {

	@Test
	void createPossibleBattles() {
		Player player = new Player();
		PossibleBattles battles = new PossibleBattles(player);
		assertEquals(3, battles.getPossibleBattles().size());
	}
	
	
	@Test
	void createEnemyPlayer() {
		Player player = new Player();
		PossibleBattles battles = new PossibleBattles(player);	
		assertEquals(3, battles.getEnemyPlayer(0).getMonsters().size());
	}

}
