import java.util.ArrayList;
import java.util.Random;

public class PossibleBattles {
	protected Player player;
	protected Player enemyPlayer;
	
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Player> possibleBattles = new ArrayList<Player>();
	
	//int difficulty = player.GetDifficuluty();
	
	PossibleBattles(Player player) {
		this.player = player;
	}
	
	public ArrayList<Player> CreatePossibleBattleList() {
		for(int i = 0; i < 3; i++) {
			possibleBattles.add(CreateEnemyPlayer());
		}
		System.out.println(possibleBattles);
		return possibleBattles;
	}
	
	
	// will need to implement of variation in the enemy's monsters depending on difficulty
	public Player CreateEnemyPlayer() {
		CreateNameList();
		Random random  = new Random();
		Store monsterCreator = new Store();
		
		ArrayList<Monster> enemyMonsters = monsterCreator.CreateMonsterList();
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
