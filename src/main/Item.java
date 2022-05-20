package main;

public interface Item {

	public default int getHealthAmount() {
		return 0 ;
		}
	
	public default int getDamageAmount() {
		return 0 ;
		}
	
	public default int getPrice() {
		return 0;
	}
	
}
