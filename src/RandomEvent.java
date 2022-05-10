import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {

    Random random = new Random();
    Player player;
    JamJar_Item item;
    int probability = random.nextInt(100);
    int monsterIndex; 



    RandomEvent(Player player){
        this.player = player;
        this.monsterIndex = random.nextInt(player.GetMonsters().size());
    }

    public void choseRandomMethod(){
    
        if(player.GetWonLastGame() == true) { 
            if(probability <= 30){
                levelUp();     
            }else if(probability <= 20) {
                levelUp();
            }
        }


        if(player.GetWonLastGame() == true){
            if(probability >30 || probability <= 40){
                monsterLeave();
            }else if (probability > 20 || probability <= 40){
                monsterLeave();
            }
        } 
        if(player.GetMonsters().size() >= 3){
            if(probability > 40 || probability <= 50){
                newMonster();
            }
        }else if(probability > 50 || probability <= 70){
            newMonster();
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
		
		RandomEvent event = new RandomEvent(player);
		event.choseRandomMethod();
    }

    
}
