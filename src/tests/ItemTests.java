package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.Item;
import main.JamJar_Item;
import main.HealthPotion_item;
import main.StrengthPotion_item;

class ItemTests {

	@Test
	void jamJarTest() {
		JamJar_Item jar = new JamJar_Item();
		assertEquals(5 , jar.getHealthAmount());
		assertEquals(5 , jar.getDamageAmount());
		assertEquals(5 , jar.getPrice());
	}
	
	
	@Test
	void strengthPotionTest() {
		StrengthPotion_item potion = new StrengthPotion_item();
		assertEquals(0 , potion.getHealthAmount());
		assertEquals(5 , potion.getDamageAmount());
		assertEquals(3 , potion.getPrice());
	}
	
	
	@Test
	void healthPotionTest() {
		HealthPotion_item potion = new HealthPotion_item();
		assertEquals(5 , potion.getHealthAmount());
		assertEquals(0 , potion.getDamageAmount());
		assertEquals(3 , potion.getPrice());
	}
	

}
