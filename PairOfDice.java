package homework402;

/**
 *  CSC300 Homework 3b:  the file name must be  PairOfDice
 *  Version 1.0
 *  
 *   Ashay Kargaonkar	
 *   CSC 402
 *   
 *  copy/paste the output in the space below
 *  ------------------------------------------------------
 *  The average number of rolls to get a value less than 5 or more than 10 was 4.000
 	The experimental probablity of the die values being within 2 of each other  0.667
 *  --------------------------------------------------------
 *  
 * This is a skeleton file for your homework. Edit the sections marked TODO.
 *
 * You must not change the declaration of any method. 
 * You may not use any other Java classes (e.g. ArrayLists, etc) without permission
 * of the instructor.
 * Do not change the main function
 */
import stdlib.StdOut;
import stdlib.StdRandom;

/*
 * The class PairOfDice implements some basic functionality
 * of a pair of dice.  You may not add any methods to this class
 * other than those indicated below.
 */
public class PairOfDice {
	private int die1, die2;

	public PairOfDice() { // constructor
		roll();
	}

	public void roll() { // randomize the dice values
		die1 = StdRandom.uniform(1, 7); // returns a random number from 1 to 6
		die2 = StdRandom.uniform(1, 7);
	}

	public boolean isDoubles() { // determines if the two die values are the name
		return die1 == die2;
	}

	public int sum() { // the the sum of the two die values
		return die1 + die2;
	}

	// ToDo 1
	// add an instance method that determines if the current dice sum is less than 5
	// or greater than 10
	// return true or false

	public boolean lessThan5GreaterThan10() {
		roll();
		sum();

		if (sum() < 5 || sum() > 10) {
			return true;
		}

		else {
			return false;
		}

	}

	// ToDo 2
	// add an instance method that determines if the dice values are within 2 of
	// each other
	// example: 1,2 are within 2 of each other; 2 5 are not within 2 of each other
	// hint boolean

	public boolean withIn2() {
		roll();
		if (Math.abs(die1 - die2) <= 2) {
			return true;
		}

		else {
			return false;
		}

	}

	// ------------------------------------- testing program ---------------------

	/*
	 * experiment 1
	 * 
	 * Q. how many rolls does it take (on the average) to roll a value less than 5
	 * or greater than 10?
	 * 
	 * first write a loop to count the number of rolls needed to roll a 2,3,4,11, or
	 * 12 For example if the rolls were: 5 8 6 5 7 11, it took 6 rolls to get an 11
	 * (this time) then add code to repeat that test 1,000,000 times. return: the
	 * average (number of rolls needed) of all the tests hint: nested loops, use the
	 * lessThan5GreaterThan10 instance method
	 */

	public static double experimentOne(PairOfDice x) {

		int sum1 = 0;
		PairOfDice p = new PairOfDice();

		for (int i = 0; i < 1000000; i++) {
			int count = 0;
			boolean check = true;
			while (check == true) {
				if (p.lessThan5GreaterThan10() == false) {
					count++;
				}

				else {
					count++;
					sum1 = sum1 + count;
					check = false;
				}
			}
		}
		return (double) sum1 / 1000000;
	}

	/*
	 * experiment 2 Question: what is the likelihood of the die values being within
	 * 2 of each other? To answer this, complete this function which should roll the
	 * dice 1,000,000 times and determine and return the percentage of rolls that
	 * are within 2 of each other.
	 * 
	 * Hint: you will need to used instance methods of the PairOfDice class
	 */
	public static double experimentTwo(PairOfDice x) {

		double count = 0;
		PairOfDice p = new PairOfDice();

		for (int i = 0; i < 1000000; i++) {
			if (p.withIn2() == true) {
				count++;
			}
		}
		return count / 1000000;

	}

	// nothing to do here
	public static void main(String[] args) {

		PairOfDice myDice = new PairOfDice();

		double rollsToGet2341112 = experimentOne(myDice);
		double probWithin2 = experimentTwo(myDice);

		StdOut.format(" The average number of rolls to get a value less than 5 or more than 10 was %5.3f\n",
				rollsToGet2341112);
		StdOut.format(" The experimental probablity of the die values being within 2 of each other  %5.3f\n",
				probWithin2);

	}

}
