package homework402;

import java.util.Arrays;
import stdlib.*;

public class CSC402Homework4 {

	/**
	 * As a model for Problem 1, here are two functions to find the minimum value of
	 * an array of ints an iterative version and a recursive version
	 *
	 * precondition: list is not empty /** iterative version
	 */
	public static double minValueIterative(int[] list) {
		int result = list[0];
		int i = 1;
		while (i < list.length) {
			if (list[i] < result)
				result = list[i];
			i = i + 1;
		}
		return result;
	}

	/**
	 * recursive version Find minimum of a list of size N starting at location 0
	 * Smaller problem is : Find minimum of list of size N-1, starting at 0
	 * 
	 * precondition: list is not empty
	 */
	public static int minValueRecursive(int[] list) {
		return minValueHelper(list, list.length);
	}

	private static int minValueHelper(int[] list, int n) {
		if (n == 1) // the list of size 1 is the single element list[0]
			return list[0]; // the minimum of this list is just that element.

		// else: find minimum of smaller list

		int minOfSmallerList = minValueHelper(list, n - 1); // recursive call, 'smaller' list

		// now compare min of smaller list to 'last' element of this list
		// the list is of size n, the 'last' element is at position n-1
		// because indexes start at 0.
		int theMin;

		if (list[n - 1] < minOfSmallerList)
			theMin = list[n - 1];
		else
			theMin = minOfSmallerList;

		return theMin;
	}

	/**
	 * PROBLEM 1: Translate the following summing function from iterative to
	 * recursive.
	 *
	 * You should write a helper method. You may not use any "fields" to solve this
	 * problem (a field is a variable that is declared "outside" of the function
	 * declaration --- either before or after). You may not use other Java
	 * classes/algorithms, e.g. Arrays.sort
	 * 
	 * Precondition: a list of ints, - maybe empty! Postcondition: the sum of the
	 * odd values is returned
	 */
	public static int sumOfOdds(int[] a) {
		int result = 0;
		int i = 0;
		while (i < a.length) {
			if (a[i] % 2 == 1)
				result = result + a[i];
			i = i + 1;
		}
		return result;
	}

	public static int sumOfOddsRecursive(int[] a) {
		return sumofOddsHelper(a, a.length);

	}
	// this would be a good place to put the helper function for #1

	private static int sumofOddsHelper(int[] a, int n) {

		if (n == 0) {
			return 0;
		}

		else {
			int sumOfSmallerArray = sumofOddsHelper(a, n - 1);

			if (a[n - 1] % 2 == 1) {
				sumOfSmallerArray = sumOfSmallerArray + a[n - 1];
			}

			return sumOfSmallerArray;
		}

	}

	/**
	 * Here is an in-place iterative function to reverse an array.
	 * 
	 * in-place means: we don't create an extra array to make our coding easier
	 *
	 */
	public static void reverseIterative(int[] a) {
		int hi = a.length - 1;
		int lo = 0;
		while (lo < hi) {
			int loVal = a[lo];
			int hiVal = a[hi];
			a[hi] = loVal;
			a[lo] = hiVal;
			lo = lo + 1;
			hi = hi - 1;
		}
	}

	/*
	 * * PROBLEM 2: Convert the above iterative function to a recursive version
	 * 
	 * You should write a helper method. You may not use any "fields" to solve this
	 * problem (a field is a variable that is declared "outside" of the function
	 * declaration --- either before or after). You may not use any other methods
	 * 
	 * Your helper function must be parameterized to allow a smaller problem to be
	 * specified. How do you reverse an array of size N? (the answer is likely NOT:
	 * reverse an array of size N-1 ! Study the iterative version above.
	 */
	public static void reverseArray(int[] a) {
		reverseArrayHelper(a, a.length); // TODO 2 replace this by a call to your recursive helper function, then write
		// the helper function below

	}

	private static int[] reverseArrayHelper(int[] a, int n) {

		int temp;

		if (n == 1) {
			return a;
		}

		else {
			int[] ans = reverseArrayHelper(a, n - 1);

			int hi = n - 1;

			for (int i = 0; i <= hi; i++) {
				if (a[i] < a[hi]) {
					temp = a[i];
					a[i] = a[hi];
					a[hi] = temp;

				}
			}

			return ans;
		}

	}

// a good place for your helper function for #2
	/**
	 * PROBLEM 3: merge together two sorted arrays of char into a new array.
	 * 
	 * The examples below Example1 merge: [a c e g ] with [ b d f h] would yield [a
	 * b c d e f g h] Example2 merge: [a f ] with [ b c h i] would yield [a b c f h
	 * i] There is no guarantee about the size of either array. When/if you run out
	 * of elements in either array, copy all the remaining elements from the
	 * nonempty array to the the new array preconditions: both arrays are sorted low
	 * to high there are no duplicate values among the two arrays either array may
	 * be empty postcondition: an array with all elements from both arrays sorted
	 * from low to high
	 * 
	 * You may not use any additional methods, sorting routines etc For full credit,
	 * your solution may only go through each array one time ( so in particular - no
	 * nested loops)
	 * 
	 * You will need to create a new array inside the function You do not have to
	 * write this recursively.
	 */

	public static char[] mergeArrays(char[] a, char[] b) {

		int length = a.length + b.length;
		int alow = 0, blow = 0;
		char[] answer = new char[length];

		if (a.length == 0)
			answer = b;
		if (b.length == 0)
			answer = a;
		else {
			for (int i = 0; i < length; i++) {
				if (alow != a.length && blow != b.length) {
					if (a[alow] < b[blow]) {
						answer[i] = a[alow];
						alow++;
					} else {
						answer[i] = b[blow];
						blow++;
					}
				}

				else {
					if (alow == a.length) {
						answer[i] = b[blow];
						blow++;
					}

					if (blow == b.length) {
						answer[i] = a[alow];
						alow++;
					}
				}

			}

		}

		return answer; // ToDo 3 . Fix this.

	}

	/*
	 * testing functions and main. There are no Todo's for you in the code below.
	 */
	public static void mergeArrayTests() {

		char one[] = new char[] { 'a', 'c', 'e', 'g', 'i', 'k' };
		char two[] = new char[] { 'b', 'd', 'f' };
		char[] combinedArray = mergeArrays(one, two);
		StdOut.println("merging: " + Arrays.toString(one) + " " + Arrays.toString(two));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		one = new char[] { 'a', 'c', 'e', 'g', 'i', 'k' };
		two = new char[] { 'b', 'd' };
		combinedArray = mergeArrays(one, two);
		StdOut.println("merging: " + Arrays.toString(one) + " " + Arrays.toString(two));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		one = new char[] { 'a', 'c', 'e', 'g', 'i', 'k' };
		two = new char[] {};
		combinedArray = mergeArrays(one, two);
		StdOut.println("merging: " + Arrays.toString(one) + " " + Arrays.toString(two));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		one = new char[] { 'b', 'k' };
		two = new char[] { 'a', 'd', 'f', 'h' };
		combinedArray = mergeArrays(one, two);
		StdOut.println("merging: " + Arrays.toString(one) + " " + Arrays.toString(two));
		StdOut.println("  --> " + Arrays.toString(combinedArray));
	}

	public static void main(String[] args) {
		int[] list0 = new int[] {};
		int[] list1 = new int[] { 5 };
		int[] list2 = new int[] { 3, 4 };
		int[] list3 = new int[] { 2, 3, 4 };
		int[] list4 = new int[] { 1, 2, 4, 5 };
		int[] list5 = new int[] { 6, 1, 2, 3, 8 };

		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list0), sumOfOddsRecursive(list0));
		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list1), sumOfOddsRecursive(list1));
		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list2), sumOfOddsRecursive(list2));
		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list3), sumOfOddsRecursive(list3));
		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list4), sumOfOddsRecursive(list4));
		StdOut.format(" list: %s  sum of odds: %d\n", Arrays.toString(list5), sumOfOddsRecursive(list5));
		StdOut.println();

		StdOut.println("Reverse: Before: " + Arrays.toString(list1));
		reverseArray(list1);
		StdOut.println("         After:  " + Arrays.toString(list1) + "\n");

		StdOut.println("Reverse: Before: " + Arrays.toString(list2));
		reverseArray(list2);
		StdOut.println("         After:  " + Arrays.toString(list2) + "\n");

		StdOut.println("Reverse: Before: " + Arrays.toString(list3));
		reverseArray(list3);
		StdOut.println("         After:  " + Arrays.toString(list3) + "\n");

		StdOut.println("Reverse: Before: " + Arrays.toString(list4));
		reverseArray(list4);
		StdOut.println("         After:  " + Arrays.toString(list4) + "\n");

		StdOut.println("Reverse: Before: " + Arrays.toString(list5));
		reverseArray(list5);
		StdOut.println("         After:  " + Arrays.toString(list5) + "\n");

		mergeArrayTests();

	}

}
