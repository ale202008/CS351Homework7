package edu.uwm.cs351;

import edu.uwm.cs351.money.Bank;
import edu.uwm.cs351.money.Stack;
import edu.uwm.cs351.money.Type;

/**
 * A variation on Towers of Hanoi
 */
public class MoveStack {

	/**
	 * Move all the coins from
	 * one stack to another, in the same order,
	 * with the help of another stack.
	 * @param from stack to get coins from, must not be null
	 * @param to stack to which the coins should be added, must not be null
	 * and must be empty.
	 * @param helper stack which can be used to hold coins temporarily.
	 * 	It must not be the same as the "to" stack, must not be null and 
	 * must not already have coins in it.
	 */
	public static void doMove(Stack from, Stack to, Stack helper) {
		// TODO: check arguments and then call recursive helper method to do work
		if (from == null) {
			return;
		}
		if (!to.isEmpty() || to == null) {
			return;
		}
		if (helper == to || helper == null || !helper.isEmpty()) {
			return;
		}
		
		int n = from.size();
		Helper(n - 1, from, to, helper);

	}
	
	// TODO: Helper method
	// Used https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/ as reference for implementation
	public static void Helper(int n, Stack left, Stack middle, Stack right) {
		
		if (n == 0) {
			right.add(left.remove());
			return;
		}
		else {
			Helper(n-1, left, right, middle);
			right.add(left.remove());
			Helper(n-1, middle, left, right);
		}
		
		
	}
	
	
	// coins to request.  We only have $2.00, so we
	// use a lot of pennies
	private static final Type[] coinsToStack = {
			Type.HALFDOLLAR, Type.DOLLAR, Type.QUARTER, 
			Type.NICKEL, Type.NICKEL, 
			Type.PENNY, Type.PENNY, Type.PENNY, Type.PENNY, Type.PENNY, 
			Type.DIME, 
	};
	
	public static void main(String[] args) {
		Bank b = Bank.getInstance();
		// TODO
		// 1. Create a stack and place in it coins
		// withdrawn from the bank (all the ones in coinsToStack).
		// 2. Create two other stacks.
		// 3. Call doMove to move coins from first stack to second stack
		// using a third stack as the helper stack.
		// Do not use spies!
		
		Stack t = new Stack();
		t.add(b.withdraw(Type.DOLLAR));
		t.add(b.withdraw(Type.PENNY));
		t.add(b.withdraw(Type.NICKEL));
		Stack y = new Stack();
		Stack u = new Stack();
	}
}
