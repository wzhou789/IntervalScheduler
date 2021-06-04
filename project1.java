import java.util.*;
import java.io.*;

public class Graph {
	  public static final int length = 1000;
	  LinkedList<Integer> edges[];

	  // Create a graph
	  Graph(){
		  edges = new LinkedList[length];
		  for (int i = 0; i < length; i++)
			  edges[i] = new LinkedList();
	  }

	  // Function to add edges
	  void addEdge(int v, int w) {
		  edges[v].add(w);
	  }

	  // Function to implement BFS
	  boolean BFS(int root, int target) {
		  boolean traversed[] = new boolean[length];
		  LinkedList<Integer> queue = new LinkedList();
		  traversed[root] = true;
		  queue.add(root);
		  //If the tree is not empty, looks for the target node
		  //while traversing the nodes in BFS order
		  while (queue.size() != 0) {
			  if(root == target) {
				  return true;
			  }
			  root = queue.poll();	      
			  Iterator<Integer> i = edges[root].listIterator();
			  while (i.hasNext()) {
				  int adj = i.next();
				  if(adj == target) {
					  return true;
				  }
				  if (!traversed[adj]) {
					  traversed[adj] = true;
					  queue.add(adj);
				  }
			  }
		  }
		  return false;
	  }
	
	  public static void main(String[] args) {
		  String input = null;
		  int count = 0;
		  int[] intArr = new int[2];
		  int root = 0;
		  int target = 0;
		  Graph tree = new Graph();
		  System.out.print("Enter edges: ");
		  
		  while(!"#".equals(input)) {		
			  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			  try {
				  input = br.readLine();
			  }catch(IOException ioe) {
				  System.out.println("Error trying to read input!");
			  }
			  if("#".contentEquals(input)) {
				  break;
			  }
			  if(!"*".contentEquals(input)) {
				  String nums[] = input.split(",");
				  if(count == 0) {
					  root = Integer.parseInt(nums[0]);
				  }
				  intArr[0] = Integer.parseInt(nums[0]);
				  intArr[1] = Integer.parseInt(nums[1]);
				  tree.addEdge(intArr[0], intArr[1]);
				  count++;
			  }
			
			  if("*".contentEquals(input)) {
				  System.out.print("Enter target node: ");
				  try {
					  input = br.readLine();
				  }catch(IOException ioe) {
					  System.out.println("Error trying to read input!");
				  }
				  target = Integer.parseInt(input);
			  }
		  }

		  if(tree.BFS(root, target)) {
			  System.out.print("Success");
		  }else {
			  System.out.print("Failure");
		  }
	  }
}
