package main;

	// interface for all item objects 
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
