import java.util.ArrayList;

public class Battle {
	Player player;
	Player enemyPlayer;
	
	ArrayList<Monster> playerMonsters = new ArrayList<Monster>();
	ArrayList<Monster> enemyMonsters = new ArrayList<Monster>();
	
	/*
	ArrayList<Monster> playerMonsters = player.GetMonsters();
	ArrayList<Monster> enemyMonsters = enemyPlayer.GetMonsters();
	
	
	Battle(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	*/
	Battle(Player player, Player enemyPlayer){
		this.player = player;
		this.enemyPlayer = enemyPlayer;
		
	}
	
	public void StartBattle() {
		Boolean fightInProgress = true;
		Monster playerMonster = player.GetFirstAlive();
		Monster enemyMonster = enemyPlayer.GetFirstAlive();
		while(fightInProgress == true ) {
			System.out.println("tryed");
			playerMonster = player.GetFirstAlive();
			enemyMonster = enemyPlayer.GetFirstAlive();
			if(player.CheckMonstersAlive() == true && enemyPlayer.CheckMonstersAlive() == true) {
				Fight(playerMonster, enemyMonster);
			} else {
				fightInProgress = false;
			}			
		}
		
		if(playerMonster != null ) {
			System.out.println("AI player lost");
		}
		if (enemyMonster != null){
			System.out.println("player lost");
		}
	}
	
	public void Fight(Monster playerMonster, Monster enemyMonster) {
		int playerDamage = playerMonster.GetDamage();
		int enemyDamage = enemyMonster.GetDamage();
		
		while(playerMonster.GetHealth() > 0 && enemyMonster.GetHealth() > 0) {
			System.out.println(playerMonster + "\n" + enemyMonster);
			playerMonster.ChangeHealth(- enemyDamage); 
			enemyMonster.ChangeHealth(- playerDamage);
		}	
		
		if (playerMonster.GetHealth() > 0) {
			enemyMonster.SetIsAlive(false);
		} else {
			playerMonster.SetIsAlive(false);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Store store = new Store();
		Store otherStore = new Store();
		
		
		Player player = new Player("hello", store.CreateMonsterList());
		Player enPlayer = new Player("bob", otherStore.CreateMonsterList());
		Battle battle = new Battle(player, enPlayer);
		
		System.out.println(battle.player + "\n" + battle.enemyPlayer);
		battle.StartBattle();
    }

}
