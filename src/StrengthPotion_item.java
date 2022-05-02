
public class StrengthPotion_item implements Item {
	private int price = 3;
	private int addedDamage = 5;
	
	public Monster ApplyItem(Player player, int monsterIndex) {
		Monster monster = (Monster) player.GetMonsters().get(monsterIndex);
		monster.ChangeDamage(addedDamage);
		return monster;
	}
	
	public int GetHealthAmount() {
		return 0;
		}
	
	
	public int GetDamageAmount() {
		return addedDamage;
		}
	
	public int GetPrice() {
		return price;
	}
	
	public String toString() {
		return "Strength potion inreaces Damage buy " + addedDamage + " and costs " + price + " coins";
	}

}
