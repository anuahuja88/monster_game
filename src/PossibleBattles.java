import java.util.ArrayList;
import java.util.Random;

public class PossibleBattles {
	private Player player;
	private Player enemyPlayer;
	private int playerMonsterLength;
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Player> possibleBattles = new ArrayList<Player>();
	
	//int difficulty = player.GetDifficuluty();
	
	PossibleBattles(Player player) {
		this.player = player;
		this.playerMonsterLength = player.GetMonsters().size();
		CreatePossibleBattleList();
	}
	
	//creates a list of three players to chose to fight
	public ArrayList<Player> CreatePossibleBattleList() {
		for(int i = 0; i < 3; i++) {
			possibleBattles.add(CreateEnemyPlayer());
		}
		return possibleBattles;
	}
	
	
	// will need to implement of variation in the enemy's monsters depending on difficulty
	public Player CreateEnemyPlayer() {
		CreateNameList();
		Random random  = new Random();
		Store monsterCreator = new Store();
		
		ArrayList<Monster> enemyMonsters = monsterCreator.CreateMonsterList(playerMonsterLength); // creates a monster list with an equal number as the main player for the enemy
		String name = names.get(random.nextInt(names.size()));
		Player enemy = new Player(name, enemyMonsters);
		
		return enemy;
		
	}
	
	public Player getPlayer(int index) {
		return possibleBattles.get(index);
	}
	

	public ArrayList<String> CreateNameList() {
		names.add("Hamish");
		names.add("Anu");
		names.add("Robert");
		names.add("Gilbert");
		names.add("Ben");
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
		battle.CreatePossibleBattleList();
		System.out.println(battle);
	
		
		
		
    }
}
