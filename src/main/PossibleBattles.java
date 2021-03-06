package main;
import java.util.ArrayList;
import java.util.Random;

	// PossibleBattles class creates a list of three player objects for the player to chose to battle from 
public class PossibleBattles {
	private Player player;
	private Player enemyPlayer;
	private int playerMonsterLength;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Player> possibleBattles = new ArrayList<Player>();
	
	
	public PossibleBattles(Player player) {
		this.player = player;
		createPossibleBattleList();
	}
	
	//creates a list of three players to chose to fight
	public ArrayList<Player> createPossibleBattleList() {
		for(int i = 0; i < 3; i++) {
			possibleBattles.add(createEnemyPlayer());
		}
		return possibleBattles;
	}
	
	
	public void resetPossibleBattles() {
		possibleBattles.clear();
		createPossibleBattleList();
	}
	// gets possible battle list
	public ArrayList<Player> getPossibleBattles() {
		return possibleBattles;
	}
	
	// will need to implement of variation in the enemy's monsters depending on difficulty
	public Player createEnemyPlayer() {
		createNameList();
		Random random  = new Random();
		Store monsterCreator = new Store();
		
		ArrayList<Monster> enemyMonsters = monsterCreator.createMonsterList(0);
		String name = names.get(random.nextInt(names.size()));
		Player enemy = new Player(name, enemyMonsters);
		
		return enemy;
		
	}
	
	public Player getEnemyPlayer(int index) {
		return possibleBattles.get(index);
	}
	

	public ArrayList<String> createNameList() {
		names.add("Hamish");
		names.add("Anu");
		names.add("Robert");
		names.add("Gilbert");
		names.add("Ben");
		names.add("Liam");
		names.add("Tom");
		names.add("John");
		return names;
	}
	
	
	public String toString() {
		String returnText = "";
		int count = 1;
		for (Player player : possibleBattles) {
			returnText += count + "\n";
			returnText += player;
			count++;
		}
		return returnText;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Player player = new Player("hello", null);
		PossibleBattles battle = new PossibleBattles(player);
		battle.createPossibleBattleList();
		System.out.println(battle);
	
		
		
		
    }
}
