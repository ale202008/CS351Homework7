package edu.uwm.cs351.money;

import java.util.NoSuchElementException;

/*
 * Andrew Le
 * Homework 7, CS 351
 */

/**
 * A FIFO container of coins.
 */
public class Pipeline extends DefaultContainer {
	protected Coin tail; // Add only this field
	
	// TODO: Add what is necessary to get correct semantics
	
	@Override //decorate
	protected boolean wellFormed() {
		
		if (!super.wellFormed()) {
			return false;
		}
		
		
		//Invariant Pipeline
		if ((head != null && tail == null) || (tail != null && tail.next != null)) {
			return report("tail is not the last coin in Pipeline");
		}
		else {
			Coin c;
			for (c = head; c != null; c = c.next) {
				if (c == tail) {
					break;
				}
			}
			if (c != tail) {
				return report("tail is not the last coin in Pipeline");
			}
		}
		
		return true;
	}
	
	@Override //implementation
	public void add(Coin c) {
		assert wellFormed() : "invariant failed at the start of Pipelineadd";
		
		if (!canAdd(c)) {
			takeOwnership(c);
			throw new IllegalArgumentException();
		}
		else {
			takeOwnership(c);
			if (isEmpty()) {
				head = tail = c;
			}
			else {
				tail.next = c;
				tail = c;
			}
		}
		
		assert wellFormed() : "invariant failed at the start of Pipelineadd";
	}
	
	@Override //implementation
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
			removed.next = null;
			relinquish(removed);
		}
		if (head == null) {
			tail = null;
		}
		
		
		assert wellFormed() : "invariant failed at end of remove";
		return removed;
	}
	

}
