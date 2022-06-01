package main;

	// the monster object stores a name, health, max health, damage and price
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
	
	public String getMonsterName() {
		return monsterName;
	}
	
	public void setMonsterName(String name) {
		this.monsterName = name;
	}
	
	public int getHealth() {
		return health;
	}

	public int getMaxHealth(){
		return maxHealth;
	}
	
	public void changeHealth(int amount) {
		if (this.health + amount >= maxHealth){
			this.health = maxHealth;
		}else {
			this.health += amount;
		}
	}

	public void setHealth(int amount){
		this.health = amount;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void changeDamage(int amount) {
		damage += amount;
	}
	
	public Boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsAlive(Boolean bool) {
		isAlive = bool;
	}
	
	public int getPrice() {
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
