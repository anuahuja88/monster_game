package main;
	
	//Increase monster health and damage by 5 and cost 5 coins 
public class JamJar_Item implements Item{
	private int price = 5;
	private int addedHealth = 5;
	private int addedDamage = 5;

	
	public int getHealthAmount() {
		return addedHealth;
		}
	
	public int getDamageAmount() {
		return addedDamage;
		}
	
	public int getPrice() {
		return price;
	}
	
	public String toString() {
		return "Jam Jar increses health by " + addedHealth + ", increases damage by " + addedDamage + " and costs " + price + " coins";
	}
}
