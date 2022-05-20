package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Player;
import main.Battle;
import main.Monster;

import org.junit.jupiter.api.Test;

class BattleTest {

	//if the player wins a battle their won last battle variable should be true
	@Test
	void playerWinTest() {	
		Monster monster1 = new Monster("testname", 20, 20 ,20, 3);
		Monster monster2 = new Monster("testname", 10, 40 ,10, 3);
		Player player = new Player();
		Player enemyPlayer = new Player();
		player.addMonster(monster1);
		enemyPlayer.addMonster(monster2);
		Battle battle = new Battle(player, enemyPlayer);
		battle.StartBattle();
		assertTrue(player.getWonLastGame());
	}
	
	
	//if the player loses a battle their won last battle variable should be false
	@Test
	void playerLostTest() {	
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 20, 40 ,20, 3);
		Player player = new Player();
		Player enemyPlayer = new Player();
		player.addMonster(monster1);
		enemyPlayer.addMonster(monster2);
		Battle battle = new Battle(player, enemyPlayer);
		battle.StartBattle();
		assertFalse(player.getWonLastGame());
	}
	
	// if the player has lost check if the revive method works correctly on easy
	@Test
	void playerLostReviveEasyTest() {	
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 20, 40 ,20, 3);
		Player player = new Player();
		player.setDifficulty(1);
		Player enemyPlayer = new Player();
		player.addMonster(monster1);
		enemyPlayer.addMonster(monster2);
		Battle battle = new Battle(player, enemyPlayer);
		battle.StartBattle();
		battle.reviveDeadMonsters();
		
		assertEquals(5 , player.getTotalHealth());   //if revived the players total health on easy should be 5
	}
	
	
	// if the player has lost check if the revive method works correctly on hard
		@Test
		void playerLostReviveHardTest() {	
			Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
			Monster monster2 = new Monster("testname", 20, 40 ,20, 3);
			Player player = new Player();
			player.setDifficulty(2);
			Player enemyPlayer = new Player();
			player.addMonster(monster1);
			enemyPlayer.addMonster(monster2);
			Battle battle = new Battle(player, enemyPlayer);
			battle.StartBattle();
			battle.reviveDeadMonsters();
			
			assertEquals(1 , player.getTotalHealth());   //if revived the players total health on hard should be 1
		}

}
