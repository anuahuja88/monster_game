package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Player;

import org.junit.jupiter.api.Test;

import main.Player;
import main.Monster;

class PlayerTest {
	
	//check if the add current day method works
	@Test
	void addDayToCurrentTest() {
		Player player = new Player();
		player.setDays(10);
		player.addCurrentDay();
		
		assertEquals(2, player.getCurrentDay());
	}
	
	@Test
	void addCoinTest() {
		Player player = new Player();
		player.changeCoins(5);
		assertEquals(15, player.getCoins());
	}
	
	@Test
	void removeCoinTest() {
		Player player = new Player();
		player.changeCoins(-5);
		assertEquals(5, player.getCoins());
	}
	
	@Test
	void buyMonsterTest() {
		Player player = new Player();
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		player.addMonster(monster);
		assertEquals(1, player.getMonsters().size());
	}
	
	@Test
	void overMonsterLimitTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster3 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster4 = new Monster("testname", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		player.addMonster(monster3);
		player.addMonster(monster4);
		assertEquals(3, player.getMonsters().size());
	}
	
	// total health of all monsters in list should be 20
	@Test
	void totalHealthTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		assertEquals(20, player.getTotalHealth());
	}
	
	// total damage of all monsters in list should be 20 
	@Test
	void totalDamageTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		assertEquals(20, player.getTotalDamage());
	}
	
	// Get the first monster alive and check if true
	@Test
	void getFirstAliveTestBlueSky() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		player.getMonster(0).setIsAlive(false);
		assertEquals("firstAlive", player.getFirstAlive().getMonsterName());
		assertTrue(player.checkMonstersAlive());
	}
	
	// Check monsters alive false
	@Test
	void checkFirstAliveTestFail() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		player.getMonster(0).setIsAlive(false);
		player.getMonster(1).setIsAlive(false);
		assertFalse(player.checkMonstersAlive());
	}
	
	
}
