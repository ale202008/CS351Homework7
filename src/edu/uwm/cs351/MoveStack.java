package edu.uwm.cs351;

import edu.uwm.cs351.money.Bank;
import edu.uwm.cs351.money.Stack;
import edu.uwm.cs351.money.Type;

/*
 * Andrew Le
 * Homework 7, CS 351
 */

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
		if (from == null || to == null || helper == null) {
			throw new NullPointerException();
		}
		if (!to.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (helper == to || !helper.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		int n = from.size();
		Helper(n, from, to, helper);

	}
	
	// TODO: Helper method
	// Used https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/ as reference for implementation
	public static void Helper(int n, Stack from, Stack to, Stack helper) {
		
		if (n == 0) {
			return;
		}
		else {
			Helper(n-1, from, helper, to);
			to.add(from.remove());
			Helper(n-1, helper, to, from);
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
		
		Stack from = new Stack();
		Stack to = new Stack();
		Stack helper = new Stack();
		
		for (int i = 0; i < coinsToStack.length; i++) {
			from.add(b.withdraw(coinsToStack[i]));
		}
		System.out.print("from Stack\n-----\n" + from.toString() );
		
		doMove(from, to, helper);
		System.out.print("\nto Stack\n-----\n" + to.toString() );

	}
}
