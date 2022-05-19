package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Player;

import org.junit.jupiter.api.Test;

import main.Player;
import main.Monster;

class PlayerTest {

	@Test
	void addDayToCurrentTest() {
		Player player = new Player();
		player.SetDays(10);
		player.AddDay();
		assertEquals(2, player.GetCurrentDay());
	}
	
	@Test
	void addCoinTest() {
		Player player = new Player();
		player.ChangeCoins(5);
		assertEquals(15, player.GetCoins());
	}
	
	@Test
	void removeCoinTest() {
		Player player = new Player();
		player.ChangeCoins(-5);
		assertEquals(5, player.GetCoins());
	}
	
	@Test
	void buyMonsterTest() {
		Player player = new Player();
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		player.BuyMonster(monster);
		assertEquals(1, player.GetMonsters().size());
	}
	
	@Test
	void overMonsterLimitTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster3 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster4 = new Monster("testname", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		player.BuyMonster(monster3);
		player.BuyMonster(monster4);
		assertEquals(3, player.GetMonsters().size());
	}
	
	// total health of all monsters in list should be 20
	@Test
	void totalHealthTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		assertEquals(20, player.getTotalHealth());
	}
	
	// total damage of all monsters in list should be 20 
	@Test
	void totalDamageTest() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("testname", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		assertEquals(20, player.getTotalDamage());
	}
	
	// Get the first monster alive and check if true
	@Test
	void getFirstAliveTestBlueSky() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		player.GetMonster(0).SetIsAlive(false);
		assertEquals("firstAlive", player.GetFirstAlive().GetMonsterName());
		assertTrue(player.CheckMonstersAlive());
	}
	
	// Check monsters alive false
	@Test
	void checkFirstAliveTestFail() {
		Player player = new Player();
		Monster monster1 = new Monster("testname", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		player.GetMonster(0).SetIsAlive(false);
		player.GetMonster(1).SetIsAlive(false);
		assertFalse(player.CheckMonstersAlive());
	}
	
	
}
