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
		RandomEvent event = new RandomEvent(player);
		Monster monster1 = new Monster("firstAlive", 10, 20 ,10, 3);
		Monster monster2 = new Monster("firstAlive", 10, 20 ,10, 3);
		player.BuyMonster(monster1);
		player.BuyMonster(monster2);
		event.newMonster();
		assertEquals(1, player.GetMonsters().size());
		
		
		
	}

}
