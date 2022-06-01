package main;
import java.util.ArrayList;

	// the player class stores a name, days(to be played), current day, difficulty (either 1 or 2)
	// coins and a boolean for one last game. it also contains a monster and item list
public class Player {
	private String name;
	private int days;
	private int currentDay = 1;
	private int difficulty;
	private int coins;
	private boolean playerSelected;
	private boolean wonLastGame = false;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Item> items = new ArrayList<Item>();
	
	public Player() {}
	
	public Player(String name, ArrayList<Monster> monsters) {
		this.name = name;
		this.monsters = monsters;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDays(int days){
		this.days = days;
	}
	
	public int getDays() {
		return days;
	}

	
	public int getCurrentDay() {
		return currentDay;
	}
	
	public void addCurrentDay() {
		currentDay++;
	}
	
	public void setDifficulty(int temp) {
		difficulty = temp;
	}
	
	public int getDifficuluty() {
		return difficulty;
	}
	public void setPlayerSelected(boolean selected) {
		playerSelected = selected;
	}
	public boolean getPlayerSelected() {
		return playerSelected;
	}

	public void setWonLastGame(boolean bool){
		wonLastGame = bool;
	}

	public boolean getWonLastGame(){
		return wonLastGame;
	}
	
	public void changeCoins(int amount) {
		coins += amount;
	}
	
	public void setCoins(int coins) {
		this.coins  = coins;
	}
	public int getCoins() {
		return coins;
	}
	
	public Monster getMonster(int index) {
		return monsters.get(index);
	}
	
	public int getTotalHealth() {
		int total = 0;
		for (Monster i : monsters) {
			total += i.getHealth();
		}
		return total;
	}
	public int getTotalDamage() {
		int total = 0;
		for (Monster i : monsters) {
			total += i.getDamage();
		}
		return total;
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public Monster getFirstAlive() {
		for(Monster monster : monsters) {
			if (monster.getIsAlive() == true ) {
				return monster;
			}
		}
		return null;
	}
	
	public Boolean checkMonstersAlive() {
		for(Monster monster : monsters) {
			if (monster.getIsAlive() == true) {
				return true;
			}
		}
		return false;
	}
	
	// return a string that contains all monsters in the monster list 
	public String monstersTeamString() {
		String returnString = "";
		for(Monster i : monsters) {
			returnString += i + "\n";
		}
		
		return returnString;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	// return a string that contains all items in the items list, make a count so items can be selected
	public String itemListString() {
		String returnString = "";
		int count = 0;
		for(Item i : items) {
			count++;
			returnString = count + ": " + i + "\n";
		}
		
		return returnString;
	}
	
	public void addMonster(Monster monster) {
		if (monsters.size() >= 3) {
			System.out.println("sorry you already have the max amount of monsters");
		} else {
			monsters.add(monster);
		}
	}
	
	
	
	public void addItem(Item selectedItem) {
		items.add(selectedItem);
	}
	
	public String toString() {
		String returnText  = "";
		returnText += name + "\n" + monstersTeamString();
		return returnText;
	}
	
}
