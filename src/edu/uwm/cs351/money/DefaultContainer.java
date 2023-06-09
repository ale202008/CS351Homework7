package edu.uwm.cs351.money;

import java.util.NoSuchElementException;


/*
 * Andrew Le
 * Homework 7, CS 351
 */

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
		if (head != null) {
			// This check uses the "tortoise and hare" algorithm attributed to Floyd.
			Coin fast = head.next;
			for (Coin p = head; fast != null && fast.next != null; p = p.next) {
				if (p == fast) return report("list is cyclic!");
				fast = fast.next.next;
			}
		}
		
		//Invariant 2
		for (Coin c = head; c != null; c = c.next) {
			if (c.owner != this) {
				return report("owner is not this container.");
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
		
		if (head == null) {
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
		for (Coin c = head; c != null; c = c.next) {
			count++;
		}
		return count;
	}

	@Override // required
	public boolean canAdd(Coin c) {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of canAdd";
		
		if (c == null) {
			return false;
		}

		if (c.owner == null) {
			return true;
		}
		
		return false;
	}

	@Override // required
	public void add(Coin c) {
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of add";
		
		
		if (!canAdd(c)) {
			takeOwnership(c);
			throw new IllegalArgumentException();
		}
		else {
			takeOwnership(c);
			c.next = head;
			head = c;
		}
		
		assert wellFormed() : "invariant failed at end of add";
		
	}

	@Override // required
	public Coin remove(){
		// TODO Auto-generated method stub
		assert wellFormed() : "invariant failed at start of remove";
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Coin removed = null;
		if (head != null) {
			removed = head;
			head = head.next;
			relinquish(removed);
		}
		
		
		assert wellFormed() : "invariant failed at end of remove";
		return removed;
	}

	@Override //implementation
	public String toString() {
		String string = "";
		for (Coin i = head; i != null; i = i.next) {
			string = string + i.type + "\n";
		}
		return string;
	}
}
