package edu.uwm.cs351.money;

import java.util.NoSuchElementException;

/**
 * A LIFO Container of Coins
 */
public class DefaultContainer implements Container {
	protected Coin head; // the only field.  Do not declare any other fields
	
	/**
	 * Report an invariant error.
	 * @param message message to print
	 */
	protected boolean report(String message) {
		System.out.println("Invariant error: " + message);
		return false;
	}

	/**
	 * Return true if the data structure invariant is established.
	 * @return the value of the predicate for the invariant
	 */
	protected boolean wellFormed() {
		// TODO: 
		// 1. No cycles allowed (use Tortoise and Hare)
		// 2. Every coin in this container must be owned by this container
		
		//Invariant 1
		for (Coin c = head; c != null; c = c.next) {
			if (c.next == head) {
				return false;
			}
		}
		
		//Invariant 2
		for (Coin c = head; c != null; c = c.next) {
			if (c.owner != this) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Start adding a coin.  We first check that we can add it
	 * and then take over ownership.
	 * @param c coin to take possession of, must be one we can add
	 */
	protected void takeOwnership(Coin c) {
		if (!canAdd(c)) throw new IllegalArgumentException("cannot add " + c);
		c.owner = this;
	}

	/**
	 * Get ready to return a coin.  We remove ownership.
	 * @param c coin to relinquish
	 */
	protected void relinquish(Coin c) {
		c.owner = null;
	}
		
	// TODO: Many methods
	
	@Override // required
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of isEmpty";
		
		if (head != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override // required
	public int size() {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of size";
		
		int count = 0;
		for (Coin c = head; c != null && c.next != null; c = c.next) {
			count++;
		}
		return count;
	}

	@Override // required
	public boolean canAdd(Coin c) {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of canAdd";

		return true;
	}

	@Override // required
	public void add(Coin c) {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of add";
		
		
		assert wellFormed() : "invariant failed at end of add";
		
	}

	@Override // required
	public Coin remove() throws NoSuchElementException {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of remove";
		
		
		assert wellFormed() : "invariant failed at end of remove";
		return null;
	}
}
