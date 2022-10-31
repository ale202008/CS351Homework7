package edu.uwm.cs351.money;

/**
 * A FIFO container of coins.
 */
public class Pipeline extends DefaultContainer {
	protected Coin tail; // Add only this field
	
	// TODO: Add what is necessary to get correct semantics
	
	protected boolean wellFormed() {
		if (!super.wellFormed()) {
			return false;
		}
		
		if (tail.next != null) {
			return report("tail is not the last coin in the Pipeline.");
		}
		
		return true;
	}
}
