import java.util.ArrayList;

public class Battle {
	Player player;
	Player enemyPlayer;
	boolean playerWon = false;
	

	Battle(Player player, Player enemyPlayer){
		this.player = player;
		this.enemyPlayer = enemyPlayer;
		
	}
	
	//run fights between every monster in the list until one team is complelty dead
	public void StartBattle() {
		Boolean fightInProgress = true;
		Monster playerMonster = player.GetFirstAlive();
		Monster enemyMonster = enemyPlayer.GetFirstAlive();
		while(fightInProgress == true ) {
			playerMonster = player.GetFirstAlive();
			enemyMonster = enemyPlayer.GetFirstAlive();
			if(player.CheckMonstersAlive() == true && enemyPlayer.CheckMonstersAlive() == true) {
				Fight(playerMonster, enemyMonster);
			} else {
				fightInProgress = false;
			}			
		}
		
		//if the monster is null it means there is no alive monsters in the players list, meaning they lost the game
		if(playerMonster != null ) {
			player.setWonLastGame(true);
			playerWon = true;
			reviveDeadMonsters();
			System.out.println("AI player lost");
		}
		if (enemyMonster != null){
			player.setWonLastGame(false);
			playerWon = false;
			reviveDeadMonsters();
			System.out.println("player lost");
		}
		
		
		
	}
	
	// checks the players difficulty, if
	//in easy set all monsters alive again and give them all 5 health, if in hard set all alive with one health
	private void reviveDeadMonsters() {
		for (Monster monster : player.GetMonsters()) {
			if(monster.GetIsAlive() == false || monster.GetHealth() < 5) {  
				monster.SetIsAlive(true);
				if(player.GetDifficuluty() == 1) {   // 1 is the equivalent to easy, 2 is hard
					monster.SetHealth(5);
				} else {
					monster.SetHealth(1);
				}
			}
		}
	}

	//run a while loop comparing the two monsters health and damage outputs end the loop when one monsters health is below 0
	//once the loop is finished determine lost and set is alive to false
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
			System.out.println("\nYour " + playerMonster.GetMonsterName() + " has beat " + enemyPlayer.GetName() + "'s " + enemyMonster.GetMonsterName() + "You gained 3 coins\n");
			player.ChangeCoins(4 - player.GetDifficuluty());  //if the difficulty is easy(1) the player gains 3 coins, if it is hard(2) they gain 2
		}else if (enemyMonster.GetHealth() > 0){
			playerMonster.SetIsAlive(false);
			System.out.println("\nYour " + playerMonster.GetMonsterName() + " has lost to " + enemyPlayer.GetName() + "'s " + enemyMonster.GetMonsterName() + "\n");
		}else {
			System.out.println("\nBoth " + playerMonster.GetMonsterName() + " and " + enemyMonster.GetMonsterName() + " have knocked eachother out\n");
			enemyMonster.SetIsAlive(false);
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

	public String battleOutcomeString() {
		String returnText = "";
		if(playerWon) {
			returnText += "Congratulations you won :)"; 
		} else {
			returnText += "You lose :/";
		}
		return returnText;
	}

}
