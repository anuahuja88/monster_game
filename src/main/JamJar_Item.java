package main;

public class JamJar_Item implements Item{
	private int price = 5;
	private int addedHealth = 5;
	private int addedDamage = 5;

	
	public Monster ApplyItem(Player player, int monsterIndex) {
		Monster monster = (Monster) player.GetMonsters().get(monsterIndex);
		monster.ChangeHealth(addedHealth);
		monster.ChangeDamage(addedDamage);
		return monster;
	}
	
	public int GetHealthAmount() {
		return addedHealth;
		}
	
	public int GetDamageAmount() {
		return addedDamage;
		}
	
	public int GetPrice() {
		return price;
	}
	
	public String toString() {
		return "Jam Jar increses health by " + addedHealth + ", increases damage by " + addedDamage + " and costs " + price + " coins";
	}
}
