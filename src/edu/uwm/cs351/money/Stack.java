package edu.uwm.cs351.money;

/**
 * A LIFO container of coins
 * that requires a coin cannot be placed on smaller ones
 */
public class Stack extends DefaultContainer {
	// TODO
	// Add the least amount that gives the required semantics.
	protected boolean wellFormed() {
		
		if (!super.wellFormed()) {
			return false;
		}
		
		for (Coin c = head; c != null && c.next != null; c = c.next) {
			if (c.type.getSize() > c.next.type.getSize()) {
				return report("coin cannot be placed on smaller ones.");
			}
		}
		return true;
	}
	
	@Override //implementation
	public boolean canAdd(Coin c) {
		assert wellFormed() : "invariant failed at the start of StackcanAdd";
		if (!super.canAdd(c)) {
			return false;
		}
		if (head != null && c != null && c.type.getSize() > head.type.getSize()) {
			return false;
		}
		return true;
	}
	
	
}
