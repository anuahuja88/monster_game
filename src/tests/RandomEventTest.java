package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.RandomEvent;
import main.Player;
import main.Monster;


class RandomEventTest {
	
	@Test
	void addMonsterTest() {
		Player player = new Player();
		Monster monster1 = new Monster("firstAlive", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		RandomEvent event = new RandomEvent(player);
		event.newMonster();
		assertEquals(3, player.getMonsters().size());
	}
	
	
	@Test
	void removeMonsterTest() {
		Player player = new Player();
		Monster monster1 = new Monster("firstAlive", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.addMonster(monster1);
		player.addMonster(monster2);
		RandomEvent event = new RandomEvent(player);
		event.monsterLeave();
		assertEquals(1, player.getMonsters().size());
	}
	
	
	@Test
	void monsterLevelUpTest() {
		Player player = new Player();
		Monster monster1 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.addMonster(monster1);
		RandomEvent event = new RandomEvent(player);
		event.levelUp();
		assertEquals(15, player.getMonster(0).getHealth());
		assertEquals(15, player.getMonster(0).getDamage());
	}
	
	
	@Test
	void monsterLevelUpAtMaxTest() {
		Player player = new Player();
		Monster monster1 = new Monster("firstAlive", 19, 20 ,10, 3);
		player.addMonster(monster1);
		RandomEvent event = new RandomEvent(player);
		event.levelUp();
		assertEquals(20, player.getMonster(0).getHealth());
		assertEquals(15, player.getMonster(0).getDamage());
	}
	

}
