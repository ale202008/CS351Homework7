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
			if (c.type.getValue() > c.next.type.getValue()) {
				return report("coin cannot be placed on smaller ones.");
			}
		}
		return true;
	}
	
//	@Override // implementation
//	public void add(Coin c) {
//		// TODO Auto-generated method stub
//		assert wellFormed() : "invariant failed at start of Stackadd";
//		
//		
//		if (!canAdd(c)) {
//			takeOwnership(c);
//			throw new IllegalArgumentException();
//		}
//		else {
//			takeOwnership(c);
//			
//			Coin i;
//			for (i = head; head != null; i = i.next) {
//				if (i.type.getValue() >= c.type.getValue()) {
//					break;
//				}
//			}
//			c.next = i.next;
//			i.next = c;
//
//		}
//		
//		assert wellFormed() : "invariant failed at end of Stackadd";
//		
//	}
}
