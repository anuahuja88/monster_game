import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {

    Random random = new Random();
    Player player;
    JamJar_Item item;
    int probability = random.nextInt(100);
    int monsterIndex = random.nextInt(player.GetMonsters().size());


    RandomEvent(Player player){
        this.player = player;
    }

    public void choseRandomMethod(){
    
        if(player.GetWonLastGame() == true) { 
            if(probability <= 40){
                levelUp();   
            } else(probability <= 20) {
                levelUp();
            }
        }
    }


    //add a jamjar item to a random monster in players monster list 
    public void levelUp(){
        int addedHealth = item.GetHealthAmount();
        int addedDamage = item.GetDamageAmount();
        int maxHealth = player.GetMonster(monsterIndex).GetMaxHealth();

        //if the added health goes above teh max health just set the health to the max health
        if(player.GetMonster(monsterIndex).GetHealth() + addedHealth < maxHealth){
            player.GetMonster(monsterIndex).ChangeHealth(addedHealth);
        }else{
            player.GetMonster(monsterIndex).SetHealth(maxHealth);;
        }
        
        player.GetMonster(monsterIndex).ChangeDamage(addedDamage);
    }

    
}
