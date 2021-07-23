package homework402;

import stdlib.*;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;

import homework402.DSIDequeue.Node;

/**
 * DSIDequeue version 1.0
 * 
 * Ashay Kargaonkar CSC 402
 * 
 * this class implements a Dequeue - a double-ended queue, where elements may be
 * added or removed from either end. addLeft means add a value to the left end,
 * addRight means add a value to the right end, similarly for removeLeft,
 * removeRight
 * 
 * The dequeue is implemented using a doubly-linked list: each node has a link
 * to the successor (next) and predecessor (prev) nodes. The instance variable
 * left is used to 'point' at the left-most node The instance variable right is
 * used to 'point' at the right-most node The instance variable N keeps a count
 * of the size of the Dequeue
 * 
 * If you are unable to complete a ToDo, comment out the code you added so the
 * function does not create a runtime exception
 * 
 * You may not add any fields to the node or list classes. You may not add any
 * methods to the node class. Do not change any 'Utility' methods that I have
 * included.
 * 
 * You should not use any loops or recursions, except possibly in
 * "deleteKthFromRight deleteKthFromRight may use one loop or recursive helper.
 * You may NOT use any arrays or other Java classes without permission.
 * 
 * Some testing code is provided, called from main. You can comment these in/out
 * while you are working on the various functions. Testing code is not
 * guaranteed to be exhaustive. You are encouraged to review the tests and see
 * if there other tests that are warranted. The testing code for functions
 * besides addRight,addLeft relies on addRight, addLeft being correct.
 * 
 * Suggestion: start with addLeft and addRight
 * 
 */

public class DSIDequeue {
	Node left, right; // three instance variables
	int N;

	static class Node { // Note the useful Node constructor
		public Node(double item, Node prev, Node next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}

		public double item;
		public Node next;
		public Node prev;
	}

	// constructor
	public DSIDequeue() {
		left = right = null;
		N = 0;
	};

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	/**
	 * addLeft
	 * 
	 * add a new node containing item as the left-most node in the Dequeue
	 * preconditions: none
	 * 
	 */
	public void addLeft(double item) {

		Node x = new Node(item, null, null);
		N++;

		if (N == 1) {
			left = x;
			right = x;
		}

		else {
			x.next = left;
			left.prev = x;
			left = x;
		}
	}

	/**
	 * addRight
	 * 
	 * add a new node containing item as the right-most node in the Dequeue
	 * preconditions: none
	 * 
	 */
	public void addRight(double item) {

		Node x = new Node(item, null, null);
		N++;

		if (N == 1) {
			left = x;
			right = x;
		}

		else {
			x.prev = right;
			right.next = x;
			right = x;
		}
	}

	/**
	 * removeLeft
	 * 
	 * remove the leftMost node in the Dequeue, returning the item in that node
	 * preconditions: none, the Dequeue may be empty, but this case is handled by
	 * throwing an exception
	 *
	 */
	public double removeLeft() {
		double ans;
		if (N == 0)
			throw new NoSuchElementException("The dequeue is empty");

		else {

			ans = left.item;
			if (N == 1) {
				left = right = null;
				N--;

			}

			else {

				N--;
				left = left.next;
				left.prev = null;
			}
		}
		return ans;

	}

	/**
	 * removeRight
	 * 
	 * remove the rightMost node in the Dequeue, return the item preconditions: none
	 * the Dequeue may be empty, but this case is handled by throwing an exception
	 * 
	 */
	public double removeRight() {
		double ans = 0;
		ans = right.item;
		if (N == 0)
			throw new NoSuchElementException();

		if (N == 1) {
			left = right = null;
			N--;
		}

		else {
			right = right.prev;
			right.next = null;
			N--;
		}
		return ans;

	}

	/**
	 * concat
	 * 
	 * The concat method should take the Nodes from "that" and add them to the right
	 * hand side of "this" After execution, "that" should be empty. See the tests in
	 * the main program.
	 *
	 * Do not use a loop or a recursive definition. This method should create no new
	 * Nodes; it may not call addLeft or addRight. preconditions: none ( either
	 * dequeue may be empty)
	 * 
	 */
	public void concat(DSIDequeue that) {
/*
		Node x = new Node(0, null, null);

		if (that.N > 0) {
			x.item = that.left.item;
			if (this.N == 0) {

				this.N++;
				that.N--;

				this.left = x;
				this.right = x;

				if (that.left != that.right) {
					that.left = that.left.next;
					that.left.prev = null;
				}

				else {
					that.left = that.right = null;
				}
			}

			else if (this.N > 0) {
				x.item = that.left.item;

				x.prev = this.right;
				this.right.next = x;
				this.right = x;

				this.N++;
				that.N--;

				if (that.N == 0) {
					that.left = that.right = null;
				}

				else {
					that.left = that.left.next;
					that.left.prev = null;

				}

			}
		}*/

	}
	

	/**
	 * deleteKthFromRight
	 * 
	 * delete and return the kth element from the right hand side (where k is
	 * between 0 and N-1). the 0th node from the right is the rightmost node See the
	 * tests in the main program.
	 *
	 * You may use a loop or a recursive definition here. This method should create
	 * no new Nodes; it may not call addLeft, addRight it MAY call removeLeft and
	 * removeRight - but think carefully about when these methods would help
	 * 
	 */
	public double deleteKthFromRight(int k) {
		if (k < 0 || k >= N)
			throw new IllegalArgumentException();

		double ans = 0;
		N--;

		if (N == 0) {
			ans = right.item;
			left = right = null;
		}

		else {

			Node t = right;

			for (int i = 0; i < k; i++) {
				t = t.prev;
			}

			if (t.next == null) {
				right = right.prev;
				right.next = null;
			}

			if (t.prev == null) {
				left = left.next;
				left.prev = null;
			}

			else {

				if (t.prev != null && t.next != null) {
					Node p = t.prev;
					Node q = t.next;
					p.next = q;
					q.prev = p;
				}

			}

			ans = t.item;

		}

		return ans;
	}

	public static void main(String args[]) {
		// Trace.drawStepsOfMethod ("main");
		// Trace.drawStepsOfMethod("addremoveTests");
		// Trace.drawStepsOfMethod("exceptionTests");
		// Trace.drawStepsOfMethod("concatTests");
		// Trace.drawStepsOfMethod("deleteKthTests");
		// Trace.drawStepsOfMethod("deleteKthFromRight"); // add more Traces if you like
		// Trace.run ();
		// addTests();
		 //addremoveTests();
		// exceptionTests();
		//concatTests();
		// deleteKthTests();

	}

	////////////////////////////////////////////////////////////////////
	// add/remove tests
	////////////////////////////////////////////////////////////////////
	public static void addTests() {

		// Here are some tests to get you started.
		// You can edit this all you like.
		DSIDequeue d1;
		double k;

		d1 = new DSIDequeue();
		d1.addLeft(11); // add a node with value 11
		check("addleft 1", d1, "[ 11 ]"); // check that dequeue d1 has a single node with value 11

		d1.addLeft(12); // add a node with value 12
		check("addleft 2", d1, "[ 12 11 ]"); // check that dequeue d1 has nodes with 12 and 11 (left to right)

		d1.addLeft(13);
		check("addleft 3", d1, "[ 13 12 11 ]");

		d1 = new DSIDequeue();
		d1.addRight(11);
		check("addright 1", d1, "[ 11 ]");

		d1.addRight(12);
		check("addright 2", d1, "[ 11 12 ]");

		d1.addRight(13);
		check("addright 3", d1, "[ 11 12 13 ]");

		d1 = new DSIDequeue();
		d1.addLeft(11);
		check("add left/right 1", d1, "[ 11 ]");

		d1.addRight(21);
		check("add left/right 2", d1, "[ 11 21 ]");

		d1.addLeft(12);
		check("add left/right 3", d1, "[ 12 11 21 ]");

		d1.addRight(22);
		check("add left/right 4", d1, "[ 12 11 21 22 ]");

		StdOut.println("Finished add-only tests");
	}

	public static void addremoveTests() {

		// Here are some tests to get you started.
		// You can edit this all you like.
		DSIDequeue d1;
		double k;

		d1 = new DSIDequeue();
		d1.addLeft(11); // add a node with value 11
		check("addRemove addleft 1", d1, "[ 11 ]"); // check that dequeue d1 has a single node with value 11

		d1.addLeft(12); // add a node with value 12
		check("left 2", d1, "[ 12 11 ]"); // check that dequeue d1 has nodes with 12 and 11 (left to right)
		d1.addLeft(13);
		check("addRemove addleft 3", d1, "[ 13 12 11 ]");
		k = d1.removeLeft();
		check("addRemove addleft 4", d1, "[ 12 11 ]", k, 13);
		k = d1.removeLeft();
		check("addRemove addleft 5", d1, "[ 11 ]", k, 12);
		k = d1.removeLeft();
		check("addRemove addleft 6", d1, "[ ]", k, 11);

		d1 = new DSIDequeue();
		d1.addRight(11);
		check("addRemove addright 1", d1, "[ 11 ]");
		d1.addRight(12);
		check("addRemove addright 2", d1, "[ 11 12 ]");
		d1.addRight(13);
		check("addRemove addright 3", d1, "[ 11 12 13 ]");
		k = d1.removeRight();
		check("addRemove addright 4", d1, "[ 11 12 ]", k, 13);
		k = d1.removeRight();
		check("addRemove addright 5", d1, "[ 11 ]", k, 12);
		k = d1.removeRight();
		check("addRemove addright 6", d1, "[ ]", k, 11);

		d1 = new DSIDequeue();
		d1.addLeft(11);
		check("addRemove leftRight 1", d1, "[ 11 ]");
		d1.addRight(21);
		check("addRemove leftRight 2", d1, "[ 11 21 ]");
		d1.addLeft(12);
		check("addRemove leftRight 3", d1, "[ 12 11 21 ]");
		d1.addRight(22);
		check("addRemove leftRight 4", d1, "[ 12 11 21 22 ]");
		k = d1.removeLeft();
		check("addRemove leftRight 5", d1, "[ 11 21 22 ]", k, 12);
		k = d1.removeLeft();
		check("addRemove leftRight 6", d1, "[ 21 22 ]", k, 11);
		k = d1.removeLeft();
		check("addRemove leftRight 7", d1, "[ 22 ]", k, 21);
		k = d1.removeLeft();
		check("addRemove leftRightt 8", d1, "[ ]", k, 22);

		d1 = new DSIDequeue();
		d1.addLeft(11);
		check("addRemove leftRight 9", d1, "[ 11 ]");
		d1.addRight(21);
		check("addRemove leftRight 10", d1, "[ 11 21 ]");
		d1.addLeft(12);
		check("addRemove leftRight 11", d1, "[ 12 11 21 ]");
		d1.addRight(22);
		check("addRemove leftRight 12 ", d1, "[ 12 11 21 22 ]");
		k = d1.removeRight();
		check("addRemove leftRight 13", d1, "[ 12 11 21 ]", k, 22);
		k = d1.removeRight();
		check("addRemove leftRight 14 ", d1, "[ 12 11 ]", k, 21);
		k = d1.removeRight();
		check("addRemove leftRight 15 ", d1, "[ 12 ]", k, 11);
		k = d1.removeRight();
		check("addRemove leftRight 16", d1, "[ ]", k, 12);
		StdOut.println("Finished add/remove tests");
	}

	////////////////////////////////////////////////////////////////////
	// test exceptions
	////////////////////////////////////////////////////////////////////
	public static void exceptionTests() {
		DSIDequeue d1;
		d1 = new DSIDequeue();
		try {
			d1.removeLeft();
			showError("Expected exception A");
		} catch (NoSuchElementException e) {
		}
		try {
			d1.removeRight();
			showError("Expected exception B");
		} catch (NoSuchElementException e) {
		}
		StdOut.println("Finished exception tests");
	}

	////////////////////////////////////////////////////////////////////
	// concat tests (and more add/remove tests)
	////////////////////////////////////////////////////////////////////
	public static void concatTests() {

		DSIDequeue d1, d2, d3;

		d1 = new DSIDequeue();
		d1.concat(new DSIDequeue());
		check("concat 1", d1, "[ ]");
		d1.addLeft(11);
		d1.concat(new DSIDequeue());
		check("concat 2", d1, "[ 11 ]");

		d1 = new DSIDequeue();
		d2 = new DSIDequeue();
		d2.addLeft(11);
		d1.concat(d2);
		check("concat 3", d1, "[ 11 ]");

		d1 = new DSIDequeue();
		for (int i = 10; i < 15; i++) {
			d1.addLeft(i);
			checkInvariants("left", d1);
		}
		for (int i = 20; i < 25; i++) {
			d1.addRight(i);
			checkInvariants("right", d1);
		}
		check("concat 4", d1, "[ 14 13 12 11 10 20 21 22 23 24 ]");

		d2 = new DSIDequeue();
		d1.concat(d2);
		check("concat 5a", d1, "[ 14 13 12 11 10 20 21 22 23 24 ]");
		check("concat 5b", d2, "[ ]");

		for (int i = 30; i < 35; i++) {
			d2.addLeft(i);
			checkInvariants("left", d2);
		}
		for (int i = 40; i < 45; i++) {
			d2.addRight(i);
			checkInvariants("right", d2);
		}
		check("concat 6", d2, "[ 34 33 32 31 30 40 41 42 43 44 ]");

		d3 = new DSIDequeue();
		d2.concat(d3);
		check("concat 6a", d2, "[ 34 33 32 31 30 40 41 42 43 44 ]");
		check("concat 6b", d3, "[ ]");

		d1.concat(d2);
		check("concat 7a", d1, "[ 14 13 12 11 10 20 21 22 23 24 34 33 32 31 30 40 41 42 43 44 ]");
		check("concat 7b", d2, "[ ]");
		for (int i = 0; i < 20; i++) {
			d1.removeLeft();
			checkInvariants("left", d1);
		}
		StdOut.println("Finished concat tests");
	}

	////////////////////////////////////////////////////////////////////
	// delete tests
	////////////////////////////////////////////////////////////////////
	public static void deleteKthTests() {

		DSIDequeue d1;
		double k;
		d1 = new DSIDequeue();
		d1.addLeft(11);
		k = d1.deleteKthFromRight(0);
		check("deleteKthFromRight test 1", d1, "[ ]", k, 11);

		d1 = new DSIDequeue();
		for (int i = 10; i < 20; i++) {
			d1.addRight(i);
			checkInvariants("right", d1);
		}
		k = d1.deleteKthFromRight(0);
		check("deleteKthFromRight test 2", d1, "[ 10 11 12 13 14 15 16 17 18 ]", k, 19);

		d1 = new DSIDequeue();
		for (int i = 10; i < 20; i++) {
			d1.addRight(i);
			checkInvariants("right", d1);
		}
		k = d1.deleteKthFromRight(5);
		check("deleteKthFromRight test 3", d1, "[ 10 11 12 13 15 16 17 18 19 ]", k, 14);

		d1 = new DSIDequeue();
		for (int i = 10; i < 20; i++) {
			d1.addRight(i);
			checkInvariants("right", d1);
		}
		k = d1.deleteKthFromRight(8);
		check("deleteKthFromRight test 4", d1, "[ 10 12 13 14 15 16 17 18 19 ]", k, 11);

		d1 = new DSIDequeue();
		for (int i = 10; i < 20; i++) {
			d1.addRight(i);
			checkInvariants("right", d1);
		}
		k = d1.deleteKthFromRight(9);
		check("deleteKthFromRight test 5", d1, "[ 11 12 13 14 15 16 17 18 19 ]", k, 10);

		StdOut.println("Finished deleteFirstFromLeftSide tests");
	}

	/**
	 * *********************************** Utility routines
	 * ***************************************
	 * 
	 */
	public DSIDequeue(String s) {
		String[] nums = s.split(" ");
		for (int i = nums.length - 1; i >= 0; i--) {
			try {
				addLeft(Double.parseDouble(nums[i]));
			} catch (NumberFormatException e) {
			}
		}
	}

	public String toString() {
		DecimalFormat format = new DecimalFormat("#.###");
		StringBuilder result = new StringBuilder("[ ");
		for (Node x = left; x != null; x = x.next) {
			result.append(format.format(x.item));
			result.append(" ");
		}
		result.append("]");
		return result.toString();
	}

	static void showError(String message) {
		Trace.draw();
		StdOut.println(message);
		// throw new Error (); // stops execution
	}

	public static void checkInvariants(String message, DSIDequeue that) {
		int N = that.N;
		DSIDequeue.Node left = that.left;
		DSIDequeue.Node right = that.right;

		if (N < 0)
			throw new Error();
		if (N == 0) {
			if (left != null || right != null) {
				showError(String.format("%s: Expected left,right == null.", message));
			}
		} else {
			if (left == null || right == null) {
				showError(String.format("%s: Expected left,right != null.", message));
			}
		}
		if (N > 0) {
			DSIDequeue.Node prev = null;
			DSIDequeue.Node current = left;
			for (int i = 0; i < N; i++) {
				if (current == null) {
					showError(String.format("%s: Expected %d next nodes, but got less.", message, N));
				}
				if (current.prev != prev) {
					showError(String.format("%s: Broken prev link.", message));
				}
				prev = current;
				current = current.next;
			}
			if (current != null) {
				showError(String.format("%s: Expected %d next nodes, but got more.", message, N));
			}
			DSIDequeue.Node next = null;
			current = right;
			for (int i = 0; i < N; i++) {
				if (current == null) {
					showError(String.format("%s: Expected %d prev nodes, but got less.", message, N));
				}
				if (current.next != next) {
					showError(String.format("%s: Broken next link.", message));
				}
				next = current;
				current = current.prev;
			}
			if (current != null) {
				showError(String.format("%s: Expected %d prev nodes, but got more.", message, N));
			}
		}
	}

	private static void check(String message, DSIDequeue actual, String expected) {
		checkInvariants(message, actual);
		if (expected != null) {
			if (!expected.equals(actual.toString())) {
				showError(message + " Expected \"" + expected + "\", got \"" + actual + "\"");
			}
		}
	}

	private static void check(String message, DSIDequeue actual, String expected, double dActual, double dExpected) {
		if (dExpected != dActual) {
			showError(message + " Expected \"" + dExpected + "\", got \"" + dActual + "\"");
		}
		check(message, actual, expected);
	}

}
