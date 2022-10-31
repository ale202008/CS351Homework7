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
		
		
		//Invariant Pipeline
		if (head != null && tail != null) {
			return report("tail is not the last coin in Pipeline");
		}
		
		Coin c;
		for (c = super.head; c != null; c = c.next) {
			if (c == tail) {
				break;
			}
		}
		if (c != tail) {
			return report("tail is not the last coin in Pipeline");
		}
		
		return true;
	}
}
