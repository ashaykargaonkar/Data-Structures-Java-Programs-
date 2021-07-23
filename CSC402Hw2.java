package homework402;

import java.util.Arrays;
import stdlib.*;

/**
 * CSC402Hw2 version 1.0
 * 
 * Ashay Kargaonkar CSC 402
 * 
 * This is a skeleton file for your programming assignment. Edit the sections
 * marked TODO. There are two credit levels to this assignment. The B-level is
 * worth 20/24 The A-level is worth 24/24 points. See the documentation for the
 * StringReformat function for more details.
 *
 * Unless specified otherwise, you must not change the declaration of any
 * method. This will be true of every skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * 
 * <pre>
 *     public static double valRange (double[] list)
 * </pre>
 * 
 * to something like
 * 
 * <pre>
 *     public static void valRange (double[] list)
 * </pre>
 * 
 * or
 * 
 * <pre>
 *     public static double valRange (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes. You should not use any HashSets
 * or ArrayLists, or anything else unless specifically indicated! Exception: You
 * may use Math.abs (look it up)
 */
public class CSC402Hw2 {

	/**
	 * valRange returns the difference between the maximum and minimum values in the
	 * array; Max-Min. Precondition: the array is nonempty. Your solution must go
	 * through the array at most once.
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *    0  == valRange (new double[] { -7 })
	 *    10 == valRange (new double[] { 1, 7, 8, 11 })
	 *    10 == valRange (new double[] { 11, 7, 8, 1 })
	 *    18 == valRange (new double[] { 1, -4, -7, 7, 8, 11 })
	 *    24 == valRange (new double[] { -13, -4, -7, 7, 8, 11 })
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static double valRange(double[] list) {

		double low = 0, high = 0;
		int i = 0;
		low = list[i];
		high = list[i];
		for (i = 1; i < list.length; i++) {

			if (list[i] < low) {
				low = list[i];
			}

			if (list[i] > high) {
				high = list[i];
			}
		}
		return high - low;
	}

	/**
	 * posOfLargestElementLtOeT returns the position of the largest element in the
	 * array that is less than or equal to the limit parameter if all values are
	 * greater than limit, return -1;
	 * 
	 * Precondition: the array is nonempty and all elements are unique. Your
	 * solution must go through the array exactly once.
	 *
	 * <pre>
	 *   0 == posOfLargestElementLtOeT(3, new double[] { -7 })                      // value:-7 is in pos 0
	 *   5 == posOfLargestElementLtOeT(3, new double[] { 11, -4, -7, 7, 8, 1 }),    // value:1 is in pos 5
	 *  -1 == posOfLargestElementLtOeT(-7, new double[] { 1, -4, -5, 7, 8, 11 }),   // all elements are > -7
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int posOfLargestElementLtOeT(double limit, double[] list) {
		int pos = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] <= limit) {
				pos = i;
				break;
			}
		}

		if (pos != -1) {
			for (int j = pos; j < list.length; j++) {
				if (list[j] <= limit && list[j] >= list[pos]) {
					pos = j;
				}

			}
		}

		return pos;

	}

	/**
	 * isPerfectNumber determines (true or false) if a given number is a 'Perfect
	 * Number'
	 * 
	 * A perfect number is one that is equal to the sum of its proper divisors.
	 * Example 1: 6; the proper divisors are 1, 2, 3 ; 1+ 2 + 3 is 6, so 6 IS a
	 * perfect number Example 2: 15; the proper divisors are 1, 3, 5 ; 1 + 3 + 5 is
	 * 9, so 15 IS NOT a perfect number Example 3: 28; the proper divisors are 1, 2,
	 * 4, 7, 14; 1 + 2 + 4 + 7 + 14 is 28, so 28 IS a perfect number
	 * 
	 * Precondition: number is a positive integer
	 *
	 * The code below is a stub version, you should replace the line of code labeled
	 * TODO with code that achieves the above specification
	 * 
	 * Hint: find the sum of the proper divisors
	 */
	public static boolean isPerfectNumber(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum = sum + i;
			}
		}

		if (sum == number) {
			return true;
		} else
			return false; // TODO 3: fix this
	}

	/**
	 * stringReformat takes a person's name in the format <Last, First Initial.> and
	 * reformats it to the form <First Initial Last>
	 *
	 * Preconditions: B-credit level a) the string is not empty b) there is exactly
	 * one ',' (comma) and it comes at the end of the Last Name c) there is 1 space
	 * after the comma d) there is exactly one space between the First Name and the
	 * Initial e) The Initial is a single character followed by a '.'
	 * 
	 * Here are some examples (using "==" informally):
	 * 
	 * "Alex P Keaton" <-- stringReformat("Keaton, Alex P."); "Luke A Boyd" <--
	 * stringReformat("Boyd, Luke A."); "Lotta B Essen" <-- stringReformat("Essen,
	 * Lotta B.");
	 * 
	 * You may only use the substring and charAt methods of the string class. You
	 * may not use any other Java classes or functions without permission Some
	 * sample code to help you think about the problem is given below for your
	 * reference; you should delete this from the solution you submit for credit.
	 * You may write additional functions to help solve this problem if you want.
	 * 
	 * Hints: Find the location of the ',' and ' ' (spaces) using charAt Build the
	 * new string by extracting the corresponding substrings and concatenating them
	 * together
	 * 
	 * A-credit level. a) the string is not empty b) there may or may not be a comma
	 * after the first name c) there is at least one space between the last and
	 * first name d) there may or may not be a middle Initial; if there is a space
	 * after the firstname, there will be a middle initial if there is a middle
	 * initial there may or may not be a period after it.
	 * 
	 * Your code will have to 'search' the input string to see which cases apply and
	 * extract the pieces correspondingly. See the test cases for some examples.
	 */
	public static String stringReformat(String name) {
		String lastName = "";
		String firstName = "";
		String initial = "";
		int i, j, k;
		for (i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ',' || name.charAt(i) == ' ') {
				break;
			} else {
				lastName = lastName + name.charAt(i);
			}

		}
		if (name.charAt(i) == ',') {
			j = i + 2;
		} else
			j = i + 1;

		for (k = j; k < name.length(); k++) {
			if (name.charAt(k) == ' ') {
				break;
			} else {
				firstName = firstName + name.charAt(k);
			}
		}
		if (k + 1 <= name.length()) {
			initial = name.charAt(k + 1) + "";
		}

		else {
			return firstName + " " + lastName;
		}

		return firstName + " " + initial + " " + lastName;
	}

	/*
	 * A test program, using private helper functions. See below.
	 */
	public static void main(String[] args) {
		// do all the tests
		valueRangeTests();
		posOfLargestElementLtOeTTests();
		perfectNumberTests();
		stringReformatTests();

		StdOut.println("Finished tests");
	}

	/*
	 * Test functions --- lot's of similar code! Do not change any of the code below
	 */

	private static void valueRangeTests() {
		// for ValRange: array must be nonempty
		testValRange(0, new double[] { 11 });
		testValRange(0, new double[] { 11, 11, 11, 11, 11 });
		testValRange(10, new double[] { 11, 1 });
		testValRange(10, new double[] { 1, 11 });
		testValRange(32, new double[] { 11, 21, 9, 31, 41 });
		testValRange(32, new double[] { 41, 21, 9, 31, 11 });
		testValRange(32, new double[] { 11, 41, 9, 31, 21 });
		testValRange(32, new double[] { -41, -21, -11, -31, -9 });
		testValRange(32, new double[] { -9, -21, -11, -31, -41 });
		testValRange(32, new double[] { -41, -11, -9, -31, -21 });
		testValRange(32, new double[] { -11, -21, -41, -31, -9 });
		testValRange(0.7, new double[] { 0.2, -0.5, -0.1 });
		StdOut.println();
	}

	private static void testValRange(double expected, double[] list) {
		double actual = valRange(list); // calls your function

		if (expected != actual) { // compares your result with the expected result
			StdOut.format("Failed valRange(%s): Expecting (%.1f) Actual (%.1f)\n", Arrays.toString(list), expected,
					actual);
		}
	}

	private static void posOfLargestElementLtOeTTests() {
		// array must be nonempty with unique elements
		// arg0: limit, arg1: answer, arg2: the array
		testposOfLargestElementLtOeT(0, 0, new double[] { 0 });
		testposOfLargestElementLtOeT(0, -1, new double[] { 1 });
		testposOfLargestElementLtOeT(0, -1, new double[] { 9, 11, 21, 31, 41 });
		testposOfLargestElementLtOeT(21, 0, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(22, 0, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(40, 3, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(41, 1, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(42, 1, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(10, 2, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(32, 3, new double[] { 21, 41, 9, 31, 11 });
		testposOfLargestElementLtOeT(12, 4, new double[] { 21, 41, 9, 31, 11 });

		StdOut.println();
	}

	private static void testposOfLargestElementLtOeT(double limit, int expected, double[] list) {

		int actual = posOfLargestElementLtOeT(limit, list); // calls your function

		if (expected != actual) { // compares your result with the expected result
			StdOut.format("Failed posOfLargestElementLtOeT(%5.2f , %s): Expecting (%d) Actual (%d)\n", limit,
					Arrays.toString(list), expected, actual);
		}
	}

	private static void stringReformatTests() {

		testStringReformat("Keaton, Alex P.", "Alex P Keaton");
		testStringReformat("Boyd, Luke A.", "Luke A Boyd");
		testStringReformat("Essen, Lotta B.", "Lotta B Essen");
		testStringReformat("Rittenoff, Candace B.", "Candace B Rittenoff");
		testStringReformat("Blank, Drew A.", "Drew A Blank");
		testStringReformat("Bruptly, Vera A.", "Vera A Bruptly");
		testStringReformat("Datso, Wanda Y.", "Wanda Y Datso");
		testStringReformat("Silver, I O.", "I O Silver");
		StdOut.println("*** A-Level test cases follow:");
		testStringReformat("Detrees Kent C", "Kent C Detrees");
		testStringReformat("Warm, Luke", "Luke Warm");
		testStringReformat("Rittenoff, Candace B", "Candace B Rittenoff");
		testStringReformat("Overwith Gladys", "Gladys Overwith");
	}

	private static void testStringReformat(String stringToTest, String expected) {

		String actual = stringReformat(stringToTest); // calls your function

		if (!actual.equals(expected)) // compares your result with the expected result
			StdOut.format("Failed  testStringReformat:  Expected: (%s)  Actual (%s) \n", expected, actual);

	}

	private static void perfectNumberTests() {

		testPerfectNumber(20, false);
		testPerfectNumber(28, true);
		testPerfectNumber(496, true);
		testPerfectNumber(495, false);
		testPerfectNumber(8128, true);
		testPerfectNumber(33550336, true);

	}

	private static void testPerfectNumber(int number, boolean expected) {

		boolean actual = isPerfectNumber(number); // calls your function

		if (actual != expected) // compares your result with the expected result
			StdOut.format("Failed  testPerfectNumber(%d):  Expected: (%b)  Actual (%b) \n", number, expected, actual);

	}

}