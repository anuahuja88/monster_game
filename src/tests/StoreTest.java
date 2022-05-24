package tests;

import static org.junit.jupiter.api.Assertions.*;
import main.Player;
import main.Store;
import main.Monster;
import main.Item;

import org.junit.jupiter.api.Test;

class StoreTest {
	
	//check if the create mosnter list method creates a list of three mosnters
	@Test
	void createMonsterListTest() {
		Store store = new Store();
		store.EmptyStore();
		store.createMonsterList();
		assertEquals(3, store.getMonsterList().size());
	}
	
	// check if the buy monster selected adds a monster into the players monser list
	@Test
	void buyMonsterSelected() {
		Store store = new Store();
		Player player = new Player();
		store.buyMonsterSelected(player, 0);
		assertEquals(1, player.getMonsters().size());
	}
	
	//
	@Test
	void createItemListTest() {
		Store store = new Store();
		assertEquals(3, store.getItemList().size());
	}
	
	
	@Test
	void buyItemSelected() {
		Store store = new Store();
		Player player = new Player();
		store.buyItemSelected(player, 0);
		assertEquals(1, player.getItems().size());
	}
	
	@Test
	void emptyStore() {
		Store store = new Store();
		store.EmptyStore();
		assertEquals(0, store.getMonsterList().size());
		assertEquals(0, store.getItemList().size());
	}

}
