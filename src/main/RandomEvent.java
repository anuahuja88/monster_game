package main;
import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {

    Random random = new Random();
    Player player;
    JamJar_Item item = new JamJar_Item();
    int probability = random.nextInt(100);
    int monsterIndex;


    boolean wonLastGame;




    public RandomEvent(Player player){
        this.player = player;
        setMonsterIndex();
    }
    public void setMonsterIndex() {
        this.monsterIndex = random.nextInt(player.GetMonsters().size());
        this.wonLastGame = player.GetWonLastGame();

    }
    public void choseRandomMethod(){
    	
    	if(probability <= 20) {
    		levelUp();
    	}
    	if (probability >= 21 && probability <= 40){
    		newMonster();
    	}
    
        if(wonLastGame) {
        	if(probability >= 41 && probability <= 50) {
        		monsterLeave();
        	} 
        }else if (probability >= 41 && probability <= 70) {
        	monsterLeave();
        }
        
        
    }


    //add a jamjar item to a random monster in players monster list 
    public void levelUp(){
        int addedHealth = item.GetHealthAmount();
        int addedDamage = item.GetDamageAmount();
        int maxHealth = player.GetMonster(monsterIndex).GetMaxHealth();

        //if the added health goes above the max health just set the health to the max health
        if(player.GetMonster(monsterIndex).GetHealth() + addedHealth < maxHealth){
            player.GetMonster(monsterIndex).ChangeHealth(addedHealth);
        }else{
            player.GetMonster(monsterIndex).SetHealth(maxHealth);;
        }
        
        player.GetMonster(monsterIndex).ChangeDamage(addedDamage);
        
        System.out.println(player.GetMonster(monsterIndex) + " Has leveled up over night!");
    }


    public void monsterLeave(){
    	System.out.println(player.GetMonster(monsterIndex) + " Has left the team overnight");
        player.GetMonsters().remove(monsterIndex);

    }
    public void newMonster(){
        Store store = new Store();
        Monster newMonster = store.CreateRandomizedMonster();
        player.BuyMonster(newMonster);
        System.out.println(newMonster + " Has joined the team overnight!");
    }
    
    public static void main(String[] args) throws InterruptedException {
    	Store store = new Store();
    	ArrayList<Monster> monsters = store.CreateMonsterList();
		Player player = new Player("hamish", monsters);
		player.setWonLastGame(false);
		RandomEvent event = new RandomEvent(player);
		event.choseRandomMethod();
    }

    
}
