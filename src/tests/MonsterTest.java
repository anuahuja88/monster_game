package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Player;
import main.Battle;

import org.junit.jupiter.api.Test;

import main.Monster;

class MonsterTest {

	
	@Test
	void healTest() {
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		monster.changeHealth(5);
		assertEquals(15, monster.getHealth());
		assertTrue(monster.getIsAlive());
	}
	
	@Test
	void changeDamageTest() {
		Monster monster = new Monster("testname", 10, 20, 10, 3);
		monster.changeDamage(5);
		assertEquals(15, monster.getDamage());
		
	}
	
	//lower the monster health below zero and set isAlive to false
	@Test
	void monsterDeathTest() {
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		assertTrue(monster.getIsAlive());
		monster.changeHealth(-15);
		monster.setIsAlive(false);
		assertEquals(-5, monster.getHealth());
		assertFalse(monster.getIsAlive());
		
	}

}
