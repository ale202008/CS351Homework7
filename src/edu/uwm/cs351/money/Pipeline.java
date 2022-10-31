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
			c.next = head;
			head = c;
		}
		
		if (head.next == null) {
			tail = head;
		}
		
		assert wellFormed() : "invariant failed at the start of Pipelineadd";
	}
	
	public Coin remove() {
		assert wellFormed() : "invariant failed at start of Pipelineremove";
		
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		Coin removed = null;
		
		if (tail != null) {
			removed = tail;
			
			if (head == tail) {
				head = tail = null;
			}
			else {
				for (Coin c = head; c != null; c = c.next) {
					if (c.next == tail) {
						c.next = null;
						tail = c;
						break;
					}
				}
			}
			
			relinquish(removed);
		}
		
		
		assert wellFormed() : "invariant failed at end of Pipelineremove";
		return removed;
	}
}
