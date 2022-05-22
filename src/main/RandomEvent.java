package main;
import java.util.ArrayList;
import java.util.Random;

	//RandomEvent runs three level up, added monster and monster leaves on a monster in the player objects monster list
	//Events are selected based on the choseRandomMethod method based on the probability variable a random number 0 to 100
	//If the player lost the last game the probability of a monster leaving goes up
public class RandomEvent {

    Random random = new Random();
    Player player;
    JamJar_Item item = new JamJar_Item();
    int probability = random.nextInt(100);
    int monsterIndex;
    boolean levelUp = false;
    boolean monsterLeave = false;
    boolean newMonster = false;


    boolean wonLastGame;




    public RandomEvent(Player player){
        this.player = player;
        setMonsterIndex();
        choseRandomMethod();
    }
    public void setMonsterIndex() {
    	if(player.getMonsters().size() == 3) {
    		this.monsterIndex = random.nextInt(3);
    	} else {
    		this.monsterIndex = 0;
    	}

        
        this.wonLastGame = player.getWonLastGame();

    }
    public int getMonsterIndex() {
    	return monsterIndex;
    }
    public void choseRandomMethod(){
    	
    	if(probability <= 20) {
    		levelUp();
    		levelUp = true;
    	}
    	if (probability >= 21 && probability <= 40){
    		newMonster();
    		newMonster = true;
    	}
    
        if(wonLastGame) {
        	if(probability >= 41 && probability <= 50) {
        		monsterLeave();
        		monsterLeave = true;
        	} 
        }else if (probability >= 41 && probability <= 70) {
        	monsterLeave();
        	monsterLeave = true;
        }
        
        
    }


    //add a jamjar item to a random monster in players monster list 
    public void levelUp(){
        int addedHealth = item.getHealthAmount();
        int addedDamage = item.getDamageAmount();
        int maxHealth = player.getMonster(monsterIndex).getMaxHealth();

        //if the added health goes above the max health just set the health to the max health
        if(player.getMonster(monsterIndex).getHealth() + addedHealth < maxHealth){
            player.getMonster(monsterIndex).changeHealth(addedHealth);
        }else{
            player.getMonster(monsterIndex).setHealth(maxHealth);;
        }
        
        player.getMonster(monsterIndex).changeDamage(addedDamage);
        
        System.out.println(player.getMonster(monsterIndex) + " Has leveled up over night!");
    }


    public void monsterLeave(){
    	System.out.println(player.getMonster(monsterIndex) + " Has left the team overnight");
        player.getMonsters().remove(monsterIndex);

    }
    public void newMonster(){
        Store store = new Store();
        Monster newMonster = store.CreateRandomizedMonster();
        player.addMonster(newMonster);
        System.out.println(newMonster + " Has joined the team overnight!");
    }
    
    public static void main(String[] args) throws InterruptedException {
    	Store store = new Store();
    	ArrayList<Monster> monsters = store.createMonsterList();
		Player player = new Player("hamish", monsters);
		player.setWonLastGame(false);
		RandomEvent event = new RandomEvent(player);
		event.choseRandomMethod();
    }

    
}
