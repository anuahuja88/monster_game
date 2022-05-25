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
	

	//
	@Test
	void createItemListTest() {
		Store store = new Store();
		assertEquals(3, store.getItemList().size());
	}
	
	

	
	@Test
	void emptyStore() {
		Store store = new Store();
		store.EmptyStore();
		assertEquals(0, store.getMonsterList().size());
		assertEquals(0, store.getItemList().size());
	}

}
