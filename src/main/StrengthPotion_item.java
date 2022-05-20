package main;

public class StrengthPotion_item implements Item {
	private int price = 3;
	private int addedDamage = 5;
	
	public Monster ApplyItem(Player player, int monsterIndex) {
		Monster monster = (Monster) player.getMonsters().get(monsterIndex);
		monster.changeDamage(addedDamage);
		return monster;
	}
	
	public int getHealthAmount() {
		return 0;
		}
	
	
	public int getDamageAmount() {
		return addedDamage;
		}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "Strength potion inreaces Damage buy " + addedDamage + " and costs " + price + " coins";
	}

}
