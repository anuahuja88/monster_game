
public class HealthPotion_item implements Item{
	private int price = 3;
	private int addedHealth = 5;
	
	
	// applies health potion to selected monster
	public Monster ApplyItem(Player player, int monsterIndex) {
		Monster monster = (Monster) player.GetMonsters().get(monsterIndex);
		monster.ChangeHealth(addedHealth);
		return monster;
	}
	

	public int GetHealthAmount() {
		return addedHealth;
		}
	
	public int GetDamageAmount() {
		return 0;
		}
	
	public int GetPrice() {
		return price;
	}
	
	public String toString() {
		return "Health potion inreaces Health by " + addedHealth + " and costs " + price + " coins";
	}

}
