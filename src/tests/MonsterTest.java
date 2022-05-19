package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Monster;

class MonsterTest {

	
	@Test
	void healTest() {
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		monster.ChangeHealth(5);
		assertEquals(15, monster.GetHealth());
		assertTrue(monster.GetIsAlive());
	}
	
	@Test
	void changeDamageTest() {
		Monster monster = new Monster("testname", 10, 20, 10, 3);
		monster.ChangeDamage(5);
		assertEquals(15, monster.GetDamage());
		
	}
	
	//lower the monster health below zero and set isAlive to false
	@Test
	void monsterDeathTest() {
		Monster monster = new Monster("testname", 10, 20 ,10, 3);
		assertTrue(monster.GetIsAlive());
		monster.ChangeHealth(-15);
		monster.SetIsAlive(false);
		assertEquals(-5, monster.GetHealth());
		assertFalse(monster.GetIsAlive());
		
	}

}
