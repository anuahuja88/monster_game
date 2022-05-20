package main;

public class HealthPotion_item implements Item{
	private int price = 3;
	private int addedHealth = 5;
	
	

	public int getHealthAmount() {
		return addedHealth;
		}
	
	public int getDamageAmount() {
		return 0;
		}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "Health potion inreaces Health by " + addedHealth + " and costs " + price + " coins";
	}

}
