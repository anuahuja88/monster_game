package main;

public interface Item {

	public default int GetHealthAmount() {
		return 0 ;
		}
	
	public default int GetDamageAmount() {
		return 0 ;
		}
	
	public default int GetPrice() {
		return 0;
	}
	
}
