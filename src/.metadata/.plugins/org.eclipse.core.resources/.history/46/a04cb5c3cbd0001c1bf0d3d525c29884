import java.util.ArrayList;
import java.util.Random;

public class Store {
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	ArrayList<Item> itemList = new ArrayList<Item>();
	private ArrayList<String> names = new ArrayList<String>();
	
	// loop three times creating a new randomized monster and adding it to the monster list
	public ArrayList<Monster> CreateMonsterList() {
		CreateNameList();
		for(int index = 0; index < 3; index++) {
			monsterList.add(CreateRandomizedMonster());
		}
		return monsterList;
	}
	
	// create a list of items 
	public ArrayList<Item> CreateItemList(){
			
			itemList.add(new JamJar_Item());
			itemList.add(new StrengthPotion_item());
			itemList.add(new HealthPotion_item());
			return itemList;
		}
	
	//enter in the index of the monster needed form the monster list and then if the players has enough coins add to the players monsters
	public void BuyMonsterSelected(Player player, int monsterIndex) {
		Monster selectedMonster = monsterList.get(monsterIndex);
		if (selectedMonster.GetPrice() <= player.GetCoins()) {
			player.BuyMonster(selectedMonster);
			player.ChangeCoins(- selectedMonster.GetPrice()); // Negative to take away from the player coins
			System.out.println(player.GetMonsters());
		} else {
			System.out.println("Not enough coins to purchase");
		}
	}
	
	//enter the index of the item and add it the players item list
	public void buyItemSelected(Player player, int itemIndex) {
		Item selectedItem = itemList.get(itemIndex);
		if (selectedItem.GetPrice() <= player.GetCoins()) {
			player.BuyItem(selectedItem);
			player.ChangeCoins(- selectedItem.GetPrice());
			System.out.println(player.GetItems());
		} else {
			System.out.println("Not enough coins to purchase");
		}
	}

		
	
	//create a random monster with random attributes
	public Monster CreateRandomizedMonster() {
		Random random = new Random();
		
		String monsterName = names.get(random.nextInt(names.size()));
		int health = random.nextInt(10) + 1;
		int maxHealth = random.nextInt(40) + 10;  //adding extra numbers works as a minimum value 
		int damage = random.nextInt(10) + 1;
		int price = 3;
		return (new Monster(monsterName, health, maxHealth, damage, price));
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
		store.CreateMonsterList();
		store.CreateItemList();
		System.out.println(store);
		
    }
}
