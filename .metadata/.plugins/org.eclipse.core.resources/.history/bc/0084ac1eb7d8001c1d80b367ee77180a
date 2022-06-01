package main;
import java.util.ArrayList;
import java.util.Random;

	//store creates two lists of monster and items and prints options to the player to buy
public class Store {
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<String> names = new ArrayList<String>();
	
	public Store(){
		createMonsterList();
		createItemList();
	}
	// loop three times creating a new randomized monster and adding it to the monster list
	public ArrayList<Monster> createMonsterList() {
		CreateNameList();
		for(int index = 0; index < 3; index++) {
			monsterList.add(CreateRandomizedMonster());
		}
		return monsterList;
	}
	
	// loop three times creating a new randomized monster and adding it to the monster list
		public ArrayList<Monster> createMonsterList(int length) {
			CreateNameList();
			for(int index = 0; index < length; index++) {
				monsterList.add(CreateRandomizedMonster());
			}
			return monsterList;
		}
	
	
	// create a list of items 
	public ArrayList<Item> createItemList(){
			
			itemList.add(new JamJar_Item());
			itemList.add(new StrengthPotion_item());
			itemList.add(new HealthPotion_item());
			return itemList;
		}
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	//enter in the index of the monster needed form the monster list and then if the players has enough coins add to the players monsters
	public void buyMonsterSelected(Player player, int monsterIndex) {
		Monster selectedMonster = monsterList.get(monsterIndex);
		if (selectedMonster.getPrice() <= player.getCoins()) {
			player.addMonster(selectedMonster);
			player.changeCoins(- selectedMonster.getPrice()); // Negative to take away from the player coins
			System.out.println(player.getMonsters());
		} else {
			System.out.println("Not enough coins to purchase");
		}
	}
	
	//enter the index of the item and add it the players item list
	public void buyItemSelected(Player player, int itemIndex) {
		Item selectedItem = itemList.get(itemIndex);
		if (selectedItem.getPrice() <= player.getCoins()) {
			player.addItem(selectedItem);
			player.changeCoins(- selectedItem.getPrice());
			System.out.println(player.getItems());
		} else {
			System.out.println("Not enough coins to purchase");
		}
	}

		
	
	//create a random monster with random attributes
	public Monster CreateRandomizedMonster() {
		Random random = new Random();
		CreateNameList();
		String monsterName = names.get(random.nextInt(6));
		int health = random.nextInt(10) + 1;
		int maxHealth = random.nextInt(12) + 10;  //adding extra numbers works as a minimum value 
		int damage = random.nextInt(10) + 1;
		int price = 3;
		return (new Monster(monsterName, health, maxHealth, damage, price));
	}
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
		
	}
	
	// add to the list of names 
	public ArrayList<String> CreateNameList() {
		names.add("Goblin");
		names.add("Fake Pikachu");
		names.add("Godly Beign");
		names.add("Scarry Guy");
		names.add("Goop Thing");
		names.add("Horrible Hands");
		
		return names;
	}
	
	
	public String toString() {
		String returnText = "Welcome to the Store! \nMonsters on sale: \n";
		int count = 0;
		for(Monster monster : monsterList) {
			count ++;
			returnText += count + ": " + monster + "\n";
		}
		
		returnText += "\nItems on sale:\n";
		for (Item item : itemList) {
			count++;
			returnText += count + ": " + item + "\n";
		}
		
		
		returnText += (count+1) + ": Return to main menu";
		
		return returnText;
	}
	
	// used to print out the monster list at the beginning setup stage of the game 
	public String MonsterListString() {
		String returnText = "";
		int count = 0;
		for(Monster monster : monsterList) {
			count ++;
			returnText += count + ": " + monster + "\n";
		}
		return returnText;
	}
	
	
	public void EmptyStore() {
		monsterList.removeAll(monsterList);
		itemList.removeAll(itemList);
	}
		
	
	public static void main(String[] args) throws InterruptedException {
		Store store = new Store();
		store.createMonsterList();
		store.createItemList();
		System.out.println(store);
		
    }
}
