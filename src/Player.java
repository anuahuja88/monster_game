import java.util.ArrayList;

public class Player {
	private String name;
	private int days;
	private int currentDay = 1;
	private int difficulty;
	private int coins = 10;
	private boolean wonLastGame = false;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Player() {}
	
	public Player(String name, ArrayList<Monster> monsters) {
		this.name = name;
		this.monsters = monsters;
		
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	public void SetDays(int days){
		this.days = days;
	}
	
	public int GetDays() {
		return days;
	}

	
	public int GetCurrentDay() {
		return currentDay;
	}
	
	public void AddDay() {
		currentDay++;
	}
	
	public void SetDifficulty(int temp) {
		difficulty = temp;
	}
	
	public int GetDifficuluty() {
		return difficulty;
	}

	public void setWonLastGame(boolean bool){
		wonLastGame = bool;
	}

	public boolean GetWonLastGame(){
		return wonLastGame;
	}
	
	public void ChangeCoins(int amount) {
		coins += amount;
	}
	
	public int GetCoins() {
		return coins;
	}
	
	public Monster GetMonster(int index) {
		return monsters.get(index);
	}
	
	public int getTotalHealth() {
		int total = 0;
		for (Monster i : monsters) {
			total += i.GetHealth();
		}
		return total;
	}
	public int getTotalDamage() {
		int total = 0;
		for (Monster i : monsters) {
			total += i.GetDamage();
		}
		return total;
	}
	
	public ArrayList<Monster> GetMonsters() {
		return monsters;
	}
	
	public Monster GetFirstAlive() {
		for(Monster monster : monsters) {
			if (monster.GetIsAlive() == true ) {
				return monster;
			}
		}
		return null;
	}
	
	public Boolean CheckMonstersAlive() {
		for(Monster monster : monsters) {
			if (monster.GetIsAlive() == true) {
				return true;
			}
		}
		return false;
	}
	
	// return a string that contains all monsters in the monster list 
	public String MonstersTeamString() {
		String returnString = "";
		for(Monster i : monsters) {
			returnString += i + "\n";
		}
		
		return returnString;
	}
	
	public ArrayList<Item> GetItems() {
		return items;
	}
	
	// return a string that contains all items in the items list, make a count so items can be selected
	public String ItemListString() {
		String returnString = "";
		int count = 0;
		for(Item i : items) {
			count++;
			returnString = count + ": " + i + "\n";
		}
		
		return returnString;
	}
	
	public void BuyMonster(Monster monster) {
		monsters.add(monster);
	}
	
	public void BuyItem(Item selectedItem) {
		items.add(selectedItem);
	}
	
	public String toString() {
		String returnText  = "";
		returnText += name + "\n" + MonstersTeamString();
		return returnText;
	}
	
}
