package main;
import java.util.ArrayList;

	//take two player objects and compare both monster lists to fins which player wins the battle
public class Battle {
	Player player;
	Player enemyPlayer;
	boolean playerWon = false;
	

	public Battle(Player player, Player enemyPlayer){
		this.player = player;
		this.enemyPlayer = enemyPlayer;
		
	}
	
	//run fights between every monster in the list until one team is dead
	public void StartBattle() {
		Boolean fightInProgress = true;
		Monster playerMonster = player.getFirstAlive();
		Monster enemyMonster = enemyPlayer.getFirstAlive();
		while(fightInProgress == true ) {
			playerMonster = player.getFirstAlive();
			enemyMonster = enemyPlayer.getFirstAlive();
			if(player.checkMonstersAlive() == true && enemyPlayer.checkMonstersAlive() == true) {
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
	public void reviveDeadMonsters() {

		for (Monster monster : player.getMonsters()) {
			if(monster.getIsAlive() == false || monster.getHealth() < 0) {  
				monster.setIsAlive(true);
				if(player.getDifficuluty() == 1) {   // 1 is the equivalent to easy, 2 is hard
					monster.setHealth(5);   // if you selected easy all dead monsters are set to 5 health
				} else {
					monster.setHealth(1);;  // if you selected hard all dead monsters are set to 1 health
				}
			}
		}
	}

	//run a while loop comparing the two monsters health and damage outputs end the loop when one monsters health is below 0
	//once the loop is finished determine lost and set is alive to false
	public void Fight(Monster playerMonster, Monster enemyMonster) {
		int playerDamage = playerMonster.getDamage();
		int enemyDamage = enemyMonster.getDamage();
		
		while(playerMonster.getHealth() > 0 && enemyMonster.getHealth() > 0) {
			System.out.println(playerMonster + "\n" + enemyMonster);
			playerMonster.changeHealth(- enemyDamage); 
			enemyMonster.changeHealth(- playerDamage);
		}	
		
		if (playerMonster.getHealth() > 0) {
			enemyMonster.setIsAlive(false);
			System.out.println("\nYour " + playerMonster.getMonsterName() + " has beat " + enemyPlayer.getName() + "'s " + enemyMonster.getMonsterName() + "You gained 3 coins\n");
			player.changeCoins(4 - player.getDifficuluty());  //if the difficulty is easy(1) the player gains 3 coins, if it is hard(2) they gain 2
		}else if (enemyMonster.getHealth() > 0){
			playerMonster.setIsAlive(false);
			System.out.println("\nYour " + playerMonster.getMonsterName() + " has lost to " + enemyPlayer.getName() + "'s " + enemyMonster.getMonsterName() + "\n");
		}else {
			System.out.println("\nBoth " + playerMonster.getMonsterName() + " and " + enemyMonster.getMonsterName() + " have knocked eachother out\n");
			enemyMonster.setIsAlive(false);
			playerMonster.setIsAlive(false);
		}
	}
	

	public static void main(String[] args) throws InterruptedException {
		Store store = new Store();
		Store otherStore = new Store();
		
		
		Player player = new Player("hello", store.createMonsterList());
		Player enPlayer = new Player("bob", otherStore.createMonsterList());
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
