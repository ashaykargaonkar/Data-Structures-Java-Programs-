package homework;

import java.beans.Visibility;

import algs13.Queue;
import algs41.Graph;
import algs41.GraphGenerator;
import stdlib.*;

//  Version 1.0 
//
//This is basically exercise 4.1.16 from the text
//   see the exercise and/or video overview for definitions and hints
//
//  The provided structure follows the design pattern illustrated
//  by the examples in 4.1
//
// you're free to add instance variables and other methods
// you should add in code to support bfs 
//	     feel free to grab and adapt this from the text and/or algs41
//  you MAY NOT use classes from algs41 as part of your solution
//  you might find queue or stack to be useful, if so use
//  the versions from algs13
//
//  you shouldn't need (or use) anything else, ask me if not sure

// you must document your code to explain your approach
// If I can't follow what you're doing, you will get reduced (or no) credit

public class DS2GraphDistance {

	int[] eccentricity; // the eccentricity of each vertex
	int diameter; // the diameter of the graph
	int radius; // the radius of the graph

	// this method just illustrates what throwing an exception might look like
	// you can delete this method
	private void anExampleMethod(Graph G) {
		boolean somethingUnpected;
		// pretend we did some investigation of G here
		somethingUnpected = true;

		if (somethingUnpected)
			throw new IllegalArgumentException("something bad happened");

	}

	private void isConnected(Graph G) {

		boolean visited[] = new boolean[G.V()];
		Queue queue = new Queue();

		queue.enqueue(0);

		while (queue.isEmpty() == false) {
			int y = (int) queue.dequeue();

			for (int w : G.adj(y)) {
				if (visited[w] == false) {
					queue.enqueue(w);
					visited[w] = true;
				}
			}
		}

		for (int x = 0; x < G.V(); x++) {
			if (visited[x] == false) {
				throw new IllegalArgumentException("Graph Not Connected");
			}
		}

		System.out.println("Graph is connected");

	}

	private void findEccentricity(Graph G) {
		for (int v = 0; v < G.V(); v++) {
			int dist = 0;
			Queue queue = new Queue();						// I was unable to understand where to include the dist variable for proper computation
			boolean visited[] = new boolean[G.V()];			

				queue.enqueue(v);
				visited[v] = true;
				
			while (queue.isEmpty() == false) {

				int x = (int) queue.dequeue();
				
				for (int w : G.adj(x)) {
					if (visited[w] == false) {
						queue.enqueue(w);
						visited[w] = true;
					}
				}
				dist++;
			}
			eccentricity[v] = dist;

		}

	}

	private void findDiameter(Graph G) {
		diameter = eccentricity(0);
		
		for(int v = 1; v < G.V(); v++) {
			
			if(eccentricity[v] > diameter) {
				diameter = eccentricity[v];
			}
		}
		
	}

	private void findRadius(Graph G) {
		
		radius = eccentricity[0];
		
		for(int v = 1; v < G.V(); v++) {
			
			if(eccentricity[v] < radius) {
				radius = eccentricity[v];
			}
		}
	}
		

	// The constructor will initiate all the calculations
	// and store the results in the instance variables above
	//
	public DS2GraphDistance(Graph G) {

		this.eccentricity = new int[G.V()];
		int diameterCalc = Integer.MIN_VALUE;
		int radiusCalc = Integer.MAX_VALUE;

		// If G.V()==0, then the above values are correct
		// otherwise the code below should update them to the correct values for the
		// graph G

		// If G is not connected, you should throw a new IllegalArgumentException()
		// This will require that you traverse the graph starting from some node (say 0)

		// I suggest that you first get this to work for a connected graph
		// You can then adjust your code so that it throws an exception in the case that
		// all nodes are not visited

		isConnected(G);
		findEccentricity(G);
		findDiameter(G);
		findRadius(G);

		// anExampleMethod(G); // just to illustrate calling a method that throws an
		// exception
		// note the try-catch block in main
		// try running the program with this commented in/out
		// you can delete this call in your final version

		// TODO
		// add code here to compute the eccentricity of each vertex, the diameter, the
		// radius
		// you will probably want to create some methods(functions) and just call them
		// from here

		//this.diameter = diameterCalc;
		//this.radius = radiusCalc;
		// this.eccentricity set these also

	}

	// Do not change the following constant time methods
	public int eccentricity(int v) {
		return eccentricity[v];
	}

	public int diameter() {
		return diameter;
	}

	public int radius() {
		return radius;
	}

	public boolean isCenter(int v) {
		return eccentricity[v] == radius;
	}

	public static void main(String[] args) {
		// ToDo test your class with different graphs by commenting in/out graphs below

		// Graph G = GraphGenerator.fromIn(new In("data/tinyG.txt")); // this is
		// non-connected -- should throw an exception
		// Graph G = GraphGenerator.connected (10, 20, 2); // Random non-connected graph
		// -- should throw an exception
		 Graph G = GraphGenerator.fromIn(new In("data/tinyCG.txt")); // diameter=2,
		// radius=2, every node is a center
		// Graph G = GraphGenerator.binaryTree(10); // A complete binary tree
		// diameter:5, radius 3
		// Graph G = GraphGenerator.path (6); // A path -- diameter=V-1
		// Graph G = GraphGenerator.connected (20, 40); // Random connected graph,
		// typical diameter 4 or 5, radius: 3 or 4

		StdOut.println(G); // comment in if you want to see the adj list
		G.toGraphviz("g.png"); // comment in if you want a png of the graph and you
		// have graphViz installed

		// nothing to change below here
		try {
			DS2GraphDistance theGraph = new DS2GraphDistance(G);
			for (int v = 0; v < G.V(); v++)
				StdOut.format("eccentricity of %d: %d\n", v, theGraph.eccentricity(v));
			StdOut.format("\ndiameter = %d\n\nradius = %d\n\n", theGraph.diameter(), theGraph.radius());
			StdOut.format("checking for centers... \n");
			for (int i = 0; i < G.V(); i++) {
				if (theGraph.isCenter(i))
					StdOut.format("center=%d\n", i);
			}
			StdOut.format("done. \n");
		} catch (IllegalArgumentException e) {
			StdOut.println(" Exception was caught: " + e.getMessage());
		}
	}
}
