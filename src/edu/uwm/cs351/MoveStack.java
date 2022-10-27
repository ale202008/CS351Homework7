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
	}
	
	// TODO: Helper method
	
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
	}
}
