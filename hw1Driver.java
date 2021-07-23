/* CSC 403
 * 
 * Ashay Kargaonkar
 * 
 * Homework 1 Driver 
 * 
 * Instructions:  using sizeTest  as a template, create additional functions to test
 *                the member functions in your LinkedListST implementation.
 *                AND
 *                create a reasonable set of test cases for each; 
 *                call your testing functions from main
 *                
 */
package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class hw1Driver {

	public static void main(String[] args) {

		// the simple testing code from the textbook pg 370
		// you may delete/comment this out if you wish
		LinkedListST<String, Integer> st = new LinkedListST<>();
		StdIn.fromFile("data/tinyST.txt");
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));

		// To do: call your testing modules

		allSizeTests();
		allSecondMaxTests();
		allRankTest();
		allFloorTest();
		allInverseTest();

	}

	public static void allSizeTests() {
		sizeTest("", 0); // test size on an empty ST (symbol table)
		sizeTest("abcde", 5); // test size on a non-empty ST
		sizeTest("ashayk", 5);
		sizeTest("kargaonkar", 6);
		sizeTest("abcd", 4);

		// ToDo add more more tests here
		// label each test case with a comment describing what you are testing for.

	}

	// sample testing function.
	// param vals: all substrings of length 1 are added to the ST
	// param answer: the correct value of the ST for the input:vals
	public static void sizeTest(String vals, int answer) {

		// create and populate the table from the input string vals
		LinkedListST<String, Integer> aList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			aList.put(vals.substring(i, i + 1), i);
		}
		// call the size function

		int result = aList.size();
		// report result
		if (result == answer) // test passes
			StdOut.format("sizeTest: Correct  String %s Answer: %d\n", vals, result);
		else
			StdOut.format("sizeTest: *Error*  String %s Answer: %d\n", vals, result);
	}

	// Todo: add your testing modules and functions here
	// See note about testing inverse function

	public static void allSecondMaxTests() {
		secondMaxTests("a", null);
		secondMaxTests("", null);
		secondMaxTests("ab", "a");
		secondMaxTests("abcde", "d");
		secondMaxTests("edcba", "d");
		secondMaxTests("abcdef", "e");
		secondMaxTests("ashay", "s");
		secondMaxTests("ashayk", "s");
		secondMaxTests("kargaonkar", "o");
	}

	public static void secondMaxTests(String vals, String answer) {
		String result = null;
		LinkedListST<String, Integer> bList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			bList.put(vals.substring(i, i + 1), i);
		}
		if (bList.size() < 2) {
			System.out.println("As size is " + bList.size() + " secondMax is null");
		} else {
			result = bList.secondMaxKey();

			if (answer.compareTo(result) == 0) // test passes
				StdOut.format("secondMaxTests: Correct  String %s Answer: %s\n", vals, result);

			else {
				StdOut.format("secondMaxTests: *Error*  String %s Answer: %s\n", vals, result);
			}
		}
	}

	public static void allRankTest() {

		rankTests("ab", "a", 0);
		rankTests("abcde", "c", 2);
		rankTests("ashay", "s", 2);
		rankTests("kargaonkar", "r", 5);
		rankTests("edcba", "c", 2);

	}

	public static void rankTests(String vals, String key, int answer) {

		LinkedListST<String, Integer> cList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			cList.put(vals.substring(i, i + 1), i);
		}
		if (cList.size() == 0) {
			System.out.println("As size is 0 so there is no rank");
		}

		int result = cList.rank(key);

		if (answer == result) // test passes
		{
			StdOut.format("rankTests: Correct  String %s Key %s Answer: %d\n", vals, key, result);
		} else {
			StdOut.format("rankTests: *Error*  String %s Key %s Answer: %d\n", vals, key, result);
		}
	}

	public static void allFloorTest() {
		floorTests("abcde", "d", "c");
		floorTests("edcba", "c", "b");
		floorTests("ashay", "s", "h");
		floorTests("kargaonkar", "g", "a");
		floorTests("a", "a", "");
	}

	public static void floorTests(String vals, String key, String answer) {

		LinkedListST<String, Integer> dList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			dList.put(vals.substring(i, i + 1), 10);
		}

		String result = dList.floor(key);

		if (answer.compareTo(result) == 0) //
			StdOut.format("floorTests: Correct  String %s Key %s Answer: %s\n", vals, key, result);

		else {
			StdOut.format("floorTests: *Error*  String %s Key %s Answer: %s\n", vals, key, result);
		}

	}

	public static void allInverseTest() {
		inverseTests1("kargaonkar", 10);
		System.out.println("---------------------------------");
		inverseTests("kargaonkar");
		System.out.println("---------------------------------");
		inverseTests("ashayk");
		System.out.println("---------------------------------");
		inverseTests("a");
		System.out.println("---------------------------------");
		inverseTests("abcde");
		System.out.println("---------------------------------");
		inverseTests("edcba");
		System.out.println("---------------------------------");
	}

	public static void inverseTests1(String vals, int a) {
		LinkedListST<String, Integer> eList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			eList.put(vals.substring(i, i + 1), a);
		}
		eList.inverse();
	}
	
	public static void inverseTests(String vals) {
		LinkedListST<String, Integer> eList = new LinkedListST<String, Integer>();
		for (int i = 0; i < vals.length(); i++) {
			eList.put(vals.substring(i, i + 1), i);
		}
		eList.inverse();
	}

}
