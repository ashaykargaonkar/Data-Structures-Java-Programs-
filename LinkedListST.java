package homework;

import algs13.Queue;

/**
 * Complete the 5 methods marked ToDo
 * You must not change the declaration of any method.
 */

/**
 * The LinkedListST class represents an (unordered) symbol table of generic
 * key-value pairs. It supports put, get, and delete methods (already
 * implemented)
 */
public class LinkedListST<Key extends Comparable<Key>, Value extends Comparable<Value>> {
	private Node first; // the linked list of key-value pairs

	// a helper linked list data type
	private class Node {
		private Key key;
		private Value val;
		private Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public LinkedListST() {
		first = null;
	}

	/**
	 * Returns the value associated with the given key in this symbol table.
	 */
	public Value get(Key key) {
		if (key == null)
			throw new NullPointerException("argument to get() is null");
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the
	 * old value with the new value if the symbol table already contains the
	 * specified key. Deletes the specified key (and its associated value) from this
	 * symbol table if the specified value is null.
	 */
	public void put(Key key, Value val) {
		if (key == null)
			throw new NullPointerException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}

		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
	}

	/**
	 * Removes the specified key and its associated value from this symbol table (if
	 * the key is in this symbol table).
	 */
	public void delete(Key key) {
		if (key == null)
			throw new NullPointerException("argument to delete() is null");
		first = delete(first, key);
	}

	// delete key in linked list beginning at Node x
	// warning: function call stack too large if table is large
	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		if (key.equals(x.key)) {
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	/**
	 * size returns the number of key-value pairs in the symbol table. it returns 0
	 * if the symbol table is empty.
	 */

	public int size() {
		int size = 0;
		for (Node t = first; t != null; t = t.next) {
			++size;
		}
		return size;
	}

	/**
	 * secondMaxKey returns the second maximum key in the symbol table. it returns
	 * null if the symbol table is empty or if it has only one key. See if you can
	 * write it with only one loop
	 */
	public Key secondMaxKey() {

		Key firstMax = first.key, secondMax = first.next.key;

		for (Node t = first.next; t != null; t = t.next) {
			if (t.key.compareTo(secondMax) >= 0) {
				secondMax = t.key;

				if (t.key.compareTo(firstMax) >= 0) {
					secondMax = firstMax;
					firstMax = t.key;
				}
			}

		}
		return secondMax;

	}

	/**
	 * rank returns the number of keys in this symbol table that is less than the
	 * given key. your implementation should be recursive.
	 */
	public int rank(Key key) {

		return rankHelper(first, key);
	}

	public int rankHelper(Node temp, Key key) {

		if (temp != null) {

			if (temp.key.compareTo(key) < 0) {
				return 1 + rankHelper(temp.next, key);
			}
			return rankHelper(temp.next, key);
		}
		return 0;
	}

	/**
	 * floor returns the largest key in the symbol table that is less than or equal
	 * to the given key. it returns null if there is no such key.
	 */
	public Key floor(Key key) {

		String answer = "";
		for (Node t = first; t != null; t = t.next) {
			if (t.key.compareTo(key) < 0) {
				if (t.key.compareTo((Key) answer) > 0) {
					answer = (String) t.key;
				}
			}
		}

		return (Key) answer;
	}

	/**
	 * inverse returns the inverse of this symbol table. if the symbol table
	 * contains duplicate values, you can use any of the keys for the inverse
	 */
	public LinkedListST<Value, Key> inverse() {

		LinkedListST<Integer, String> fList = new LinkedListST<Integer, String>();

		for (Node t = first; t != null; t = t.next) {

			Value key = t.val;
			Key value = t.key;

			fList.put((Integer) key, value + "");
		}

		for (Node t = first; t != null; t = t.next) {
			System.out.println(t.key + "     " + t.val);
		}

		System.out.println("*********************");
		
		for (Node t = (LinkedListST<Key, Value>.Node) fList.first; t != null; t = t.next) {
			System.out.println(t.key + "     " + t.val);
		}

		return (LinkedListST<Value, Key>) fList;

	}

	public Iterable<Key> keys() {
		Queue<Key> theKeys = new Queue<Key>();
		for (Node temp = first; temp != null; temp = temp.next) {
			theKeys.enqueue(temp.key);
		}
		return theKeys;
	}
}