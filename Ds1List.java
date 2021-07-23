
package homework402;

import stdlib.StdOut;
import stdlib.StdRandom;

// Ds1List   version 1.1
//    Change:  array data type in helper functions
//             changed from int to char
//   
//   Ashay Kargaonkar
//    
//   You are allowed to work with a partner on this assignment. If you elect to do so, each
//   partner must turn in copies of both files.  Both files must have the names of the two partners
//   on line 9 above.  
//   
//   In this homework you will implement a scaled down version of the Java List Interface
//    As noted in class, Java provides two implementations of the List Interface:
//        -  ArrayList :   using resizable arrays
//        -  Linkedlist:   using a linked list of nodes
// 
//  And so this List ADT can be implemented using either a basic Java array or linked structure
//  Each implementation has performance advantages and disadvantages
//
//  a Simplification:    The Java List interface is GENERIC; this one is NOT
//                       You are implementing a 'list' of characters - char
//
//  You will complete this exercise twice, once for each possible implementation
//  Eclipse will not allow you to have two copies of the same class file in one package
//  So you can either: 
//    A)  complete one version of the exercise; save the Java file for submission
//        complete the second version, starting with a fresh copy of the starter file
//    B)  put a copy of the starter file in two separate packages, this will allow you to
//        have access to both versions at the same time ( be sure you know which is which)
//   Complete all the ToDos   in this order:
//   Setup:      ToDo 0.1, ToDo 0.2, ToDo 0.3, ToDo 0.4
//   Functions:  ToDo 1,   ToDo 2,   ToDo 3,   ToDo 4,   ToDo 5 , ToDo 6
//
//-------------------------------------------------------------------------------------------
//    Some helper functions are provided for you
//    Do not change them (except as noted below) since some of them are used in the testing framework
//    the Print function requires that your version of  get  be correctly implemented
//
//    createFrom  can be used to populate  your list using data from an input String.
//             you will need to comment-in the correct part corresponding to your implementation choice
//    
//    resize   this only applies to array implementations. 
//             to use it you will need to comment-in the body of the function
//
//    print      will print the list information:  size and contents.  
//------------------------------------------------------------------------------------------------
//    Note that the provided testing framework will not work correctly until you have completed some of the
//    required functions.  And all testing is NOT automated; in some cases you will need to examine the output and verify
//    that the output is as expected.
//
//    You may not use any other Java classes or algorithms in creating your solutions.
//    
public class Ds1List {

	// ToDo 0.1

	// choose the implementation for your container  
	//  a) linked list
	//  b) resizing array

	// ToDo  0.2
	//   choose your private data variables:   comment-in the ones you want:   A  or B
	//   you can delete the other ones if you want
	//   you will also need to comment-in the relevant sections in the helper functions at the bottom of the file
	//  --> ToDo 0.3, 0.4

	//      
	private  Node  first;    // reference to the beginning of the list
	static class Node {
		public Node (char item, Node next) { this.item = item; this.next = next; }
		public char item;
		public Node next;
	}

	//  B
	//	private   char[] a;     // a is to be a resizeable array
	//	private   int  N;       // how many spaces in the array are currently used, NOT necessarily the array size

	public Ds1List ( ) {   // the List constructor

		// ToDo 1  initialize your private data
		//   for an array start with an array of size 5, Note that N will NOT be 5 
		//   for a linked list, you need to initialize the variable   first 
		first = null;
	}
	
	// In the start there are no nodes, therefore the first variable is declared as null. That's why this statement in written in the constructor.

	// size
	//
	//  return the number of elements in the list.
	//      this *may not be* the same as the size of the array 
	public int size() {
		int count = 0;
		for ( Node t = first; t != null; t=t.next)
			count++;
		return count;  // toDo 2  fix this
	}
	
	// In the code above for loop is used to travel the whole linked list. And while doing this we add one to the count variable to get the size of the linked list.
	// That's why count variable is added by one everytime we travel to the next node.
	// 
	
	

	//  get
	//
	//  return the value in position i of your list
	//  Hint:  for an array this is *really* easy
	//              for a linked list, you will need to traverse the list, counting as  you go
	// precondition:   i  is a valid position for the list  
	public char get( int  i) {
		int count = 0;
		for ( Node t = first; t != null; t=t.next) {
			if ( count == i) return t.item;
			count++;
		}
		return '*';  // ToDo 3  fix this
		
		
		// In above functions for loop is used to traverse the whole linked list.
		// count variable is used to get the position at which we are currently accessed node
		// and count variable is compared to i (parameter) so that we can use the if statement and check if count equal to or not to i.
		// If we get count is equal to i, the value of the node is displayed.
		// this is how the value at ith position is returned as the output.
		
		
		
		
		
		
		
	}

	// remove
	//
	// delete and return the element in position k (where k is between 0 and N-1 inclusive)
	// positions are numbered starting with 0, N is the size of the list
	// preconditions:  0 <= k <= N-1
	//                            :  N >=1 ; list is not empty
	//     Examples:   
	//             10   20   30   40   50,   remove(0)  would result in:    20  30  40  50
	//             10   20   30   40   50,   remove(1)  would result in:    10  30  40  50
	//             10   20   30   40   50,   remove(4)  would result in:    10   20  30  40 
	//   Hint:  for an array, you will need to move every value with index > k left one position
	//          for a linked list you will need to delete the node in that position
	//              deleting the first node in a linked list is a special case to handle
	public char remove (int k) {
		char value = '*';
		if ( k == 0) { // remove front
			value = first.item;
			first = first.next;
		}
		else {
			int count = 0;
			for (Node t=first; t != null; t=t.next) {
				if ( count+1 == k) {
					value = t.next.item;
					t.next = t.next.next;
					return value;
				}
				count++;
			}
		}
		// ToDo 4
		return value;
	}

	// first if statement handles the edge case where the first node has to be deleted.
	// if the first node is to be deleted, then we can retrieve the value as first.item and the first will be the node after first i.e. first = first.next
	
	// else statement handles the remaining cases. Here for loop is used to traverse the linked list.
	// if statement inside the for loop is used to check if we reached the node we want.
	// count+1 is used so that we should not jump on the next node else we wont be able to go back to the previous node; while using for-loop.
	// when the if condition becomes true, value is retrieved by t.next.item
	// and we have to change the next reference of the current node by saying t.next = t.next.item
	
	
	
	
	
	
	

	
	
	// add
	//
	// insert a new value into the list at position k with value: val
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//               list may be empty
	//  Hint:  
	//     for an array, you will need to move every value with index >= k right one position
	//     for an array, this operation may require resizing the array. A resize method is provided for you;
	//         just invoke   resize( newCapacity );  
	//    for a linked list:  inserting at the front of a list is a special case
	public void add( int k, char value) {
		if ( k == 0) {
			first = new Node(value, first);
		}
		else {
			int count = 0;
			for (Node t = first; t != null; t = t.next) {
				if ( count+1 == k) {
					t.next = new Node(value,t.next);
				}
				count++;
			}
		}
		//ToDo 5    fix this
	}
	
	// if loop solve the edge case problem of adding a node at the start of linked list.
	// the new node is created giving it the value and first as the next reference. thats why, first = new Node(value, t.next)
	// as this new variable will be first thats why the new node is saved in variable first.
	// else loop manages the others problems where are have to add the node in middle or end of the linked list.
	// again, like last code, count+1==k is used so that we wont jump on the next code and unable to used the current node.
	// count variable is used to determine which node us currently being accessed.
	// here new node is added on the next reference of current node. thats why, t.next = new Node(value, t.next)
	
	
	
	
	
	
	
	
	
	
	

	// contains
	//
	// returns true if the list contains the value: val;  false otherwise
	//
	public boolean contains( char val) {

		for (Node t = first; t != null; t=t.next) {
			if ( t.item == val) return true;
		}

		return false; // ToDo 6  fix this
	}
	
	// this function is simply traversing the whole linked list using for loop.
	// and every item of the node is compared to the value provided through the parameter.
	// if t.item==val i.e. if value is present in the linked list then the function will return true; else it will return false.
	
	
	

	public static void main(String[] args) {

		// comment out tests you want to skip while working on the assignment
		// comment all in when you submit the assignment

		testSizeMethod();
		testGetMethod();
		testaddMethod();
		testremoveMethod();
		testContainsMethod();
	}

	// Testing functions
	//   Each testing function contains at least one sample test case.
	//   Review these test cases and then develop your own test case ( test something different than the example tests!)
	//   Include a comment and a print statement that indicates what you are trying test for.  Hint: think about the extremes

	private static void sizeTest( String data1, int expected) {
		// Test #1 
		Ds1List x = createFrom( data1 );
		StdOut.println("----------size test ------------------------");
		print(x);
		int result = x.size(); // test:    
		if ( result == expected ) 
			StdOut.println("   test successful");
		else
			StdOut.format("   test fails.  expected %d  actual %d \n", expected, result);
	}
	public static void testSizeMethod() {

		sizeTest( "dabcfgh", 7);
		sizeTest( "d", 1);
	}

	private static void getTest( String data1, int index, int expected) {
		// Test #1 
		Ds1List x = createFrom( data1 );
		StdOut.println("----------Get test   get element " + index + " ------------------------");
		print(x);
		int actual = x.get(index); // test:    
		if ( actual == expected ) 
			StdOut.println("   test successful");
		else
			StdOut.format("   test fails.  expected %c  actual %c", expected, actual);
	}

	public static void testGetMethod() {
		getTest( "axfgefh",  2, 'f');  // value in position 2 is 9
		getTest( "xabefgy", 0,'x');  // value in position 2 is 4

		// Bonus: ToDo   T1    add one test case after the print statement below
		// should be substantively different from the above two tests
		// you MUST include a comment which describes qualitatively what 'case' your test is testing
		// uncomment the following line
		// StdOut.println("MY bonus test: "); 

	}
	private static void addTest( String data1, char data, int index) {
		Ds1List x = createFrom( data1 );
		StdOut.println("----------add test   add " + data + " at " + index + " ------------------------");
		print(x);
		x.add(index, data);
		StdOut.format("test:  add(%c, %d)       \nResult: \n", data, index); 
		print(x);

	}
	public static void testaddMethod() {

		addTest( "abcdefg",  'x', 0);  // add 2 in position 0
		addTest( "abcdefg", 'x',  3);  // add 5 in position 3

		// Bonus: ToDo   T2    add one test case after the print statement below
		// should be substantively different from the above two tests
		// you MUST include a comment which describes qualitatively what 'case' your test is testing
		// uncomment the following line
		// StdOut.println("MY bonus ADD test: "); 

	}

	private static void removeTest( String data1, int index, char expected) {
		Ds1List x = createFrom( data1 );
		StdOut.println("----------test remove   remove " + index + " ------------------------");
		print(x);
		char actual  = x.remove(index);	// remove a value at position index
		if ( expected == actual )
			StdOut.println(" correct result returned");
		else
			StdOut.format(" test fails.  expected %c , actual %c \n", expected, actual);
		StdOut.println("Result:");
		print(x);

	}
	public static void testremoveMethod() {


		removeTest("xmabefq", 2,'a');  //  remove element 2, should return 'a'
		removeTest("potato", 0,'p');   //  remove element 0, should return 'p'


		// Bonus: ToDo   T3    add one test case after the print statement below
		// should be substantively different from the above two tests
		// you MUST include a comment which describes qualitatively what 'case' your test is testing
		// uncomment the following line
		// StdOut.println("MY bonus REMOVE test: "); 
	}

	private static void containsTest( String data1, char key, boolean expected) {
		// Test #1 
		Ds1List x = createFrom( data1 );
		StdOut.println("----------test Contains     contains" + key + " ------------------------");
		print(x);
		boolean result = x.contains(key); // test:    
		if ( result == expected ) 
			StdOut.println("   test successful");
		else
			StdOut.println("   test fails");
	}
	public static void testContainsMethod() {

		containsTest( "dabcfgh", 'c', true);
		containsTest( "dabcfgh", 'z', false);

		// Bonus: ToDo   T4    add one test case after the print statement below
		// should be substantively different from the above two tests
		// you MUST include a comment which describes qualitatively what 'case' your test is testing
		// uncomment the following line
		// StdOut.println("MY bonus CONTAINS test: "); 


	}


	// ---------------------------------------------------------------------------------------------
	// Helper functions.  
	//
	// print
	// print the list information
	//   requires the  get function to be properly implemented
	//   the is called by the testing framework to show the before
	//   and after versions of the underlying list
	//   you can also use this in debugging your code
	public static void print( Ds1List a) {

		StdOut.print("List: ");
		for (int i=0; i < a.size(); i++)
			StdOut.format(" %c ", a.get(i));
		StdOut.format("   size: %d\n", a.size());

	}

	//createFrom
	//  creates a list instance using the input array data
	//  comment in/out the segment corresponding to your implementation
	//  for an array implementation the array size will be exactly equal to the data array size
	//
	//  To Do 0.3
	public static Ds1List createFrom(String data) {

		Ds1List result = new Ds1List ();
		//A   List creation code
		//Comment-in the code below if you are using a linked list implementation
		Node first = null;

		for (int i=data.length()-1; i >=0; i--) 
			first = new Node (data.charAt(i), first);  

		result.first = first;

		//  B   Array creation code
		//  Comment-in the code below if you are using an array implementation
		//	
		//		char[] temp = new char[data.length];
		//		for (int i=0; i < temp.length; i++ ) temp[i] = data.charAt(i);
		//		result.a = temp;
		//		result.N= data.length;

		return result;

	}

	// resize
	// resizes the array to the specified capacity
	//     copies the old data to the new space
	//     precondition:  capacity >= a.length
	// ToDo 0.4  Comment-in the body of this function if you are doing the array implementation
	// You will want to call this function whenever the underlying array needs to be resized.
	private void resize(int capacity) {
		//	StdOut.println("***** array resized *****");
		//	char[] b = new char[capacity];
		//	for ( int i=0; i < a.length; i++) b[i] = a[i];
		//
		//	a = b;
	}

}



