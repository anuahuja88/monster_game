
public class Monster {
	private String monsterName;
	private int health;
	private int maxHealth;
	private int damage;
	private int price;
	private Boolean isAlive = true;
	
	
	public Monster(String name, int health, int maxHealth, int damage, int price) {
		this.monsterName = name;
		this.health = health;
		this.maxHealth = maxHealth;
		this.damage = damage;
		this.price = price;
	}
	
	public String GetMonsterName() {
		return monsterName;
	}
	
	public void SetMonsterName(String name) {
		this.monsterName = name;
	}
	
	public int GetHealth() {
		return health;
	}
	
	public void ChangeHealth(int amount) {
		this.health += amount;
	}
	
	public int GetDamage() {
		return damage;
	}
	
	public void ChangeDamage(int amount) {
		damage += amount;
	}
	
	public Boolean GetIsAlive() {
		return isAlive;
	}
	
	public void SetIsAlive(Boolean bool) {
		isAlive = bool;
	}
	
	public int GetPrice() {
		return price;
	}
	
	public String toString() {
		return (monsterName + " current health:" + health + ", max health:" + maxHealth + ", attack damage:" + damage + ", price: $" + price );
	}
	
	public static void main(String[] args) throws InterruptedException {
		Monster i = new Monster("hello", 4, 30, 5,2);
		System.out.println(i);
    }
}
