package treeTesters;

import positionInterfaces.Tree;
import positionTree.BTNode;
import positionTree.LinkedBinaryTree;
import positionTree.LinkedBinaryTreeBFS;
import positionTree.LinkedBinaryTreeInOI;
import positionTree.LinkedBinaryTreePostOI;
import positionTree.LinkedBinaryTreeStack;

public class LinkedBinaryTreeTester {

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<Integer>(); 
		BTNode<Integer> v; 
		
		v = (BTNode<Integer>) t1.addRoot(4); 

		t1.insertLeft(v, 9);
		t1.insertLeft(v.getLeft(),7);
		t1.insertRight(t1.left(v),10);
		
		
		t1.insertRight(v, 20);
		t1.insertLeft(t1.right(v), 15);
		t1.insertRight(t1.right(v),21);
		
		t1.insertLeft(v.getRight().getLeft(),12);
		t1.insertRight(v.getRight().getLeft(),17);
		t1.insertLeft(v.getRight().getLeft().getRight(),19);
		
		t1.insertRight(v.getRight().getRight(),40);
		t1.insertLeft(v.getRight().getRight().getRight(),30);
		t1.insertRight(v.getRight().getRight().getRight(), 45);
		
		showTreeElements(t1); 
		
		t1.makeEmpty(); 
		showTreeElements(t1); 
		
		
		
		//POSTOI
		LinkedBinaryTreePostOI<Integer> t2 = new LinkedBinaryTreePostOI<Integer>(); 
		//Made this one with variables to made sure I understood 
		BTNode<Integer> x;
		x = (BTNode<Integer>) t2.addRoot(4); 
		BTNode<Integer> rootchild2 = (BTNode<Integer>) t2.insertLeft(x, 9);
		BTNode<Integer> rootChild1 = (BTNode<Integer>) t2.insertRight(x, 20);
		t2.insertLeft(rootchild2,7);
		t2.insertRight(rootchild2,10);
		
		BTNode<Integer> pos1 =(BTNode<Integer>) t2.insertLeft(rootChild1, 15);
		BTNode<Integer> pos2 = (BTNode<Integer>) t2.insertRight(t2.right(x),21);
		
		t2.insertLeft(pos1,12);
		BTNode<Integer> pos3 = (BTNode<Integer>) t2.insertRight(pos1,17);
		t2.insertLeft(pos3,19);
		
		BTNode<Integer> pos4 = (BTNode<Integer>) t2.insertRight(pos2,40);
		t2.insertLeft(pos4,30);
		t2.insertRight(pos4, 45);
		showTreeElements(t2);
		
		
		//INOI
		LinkedBinaryTreeInOI<Integer> t3 = new LinkedBinaryTreeInOI<Integer>(); 
		BTNode<Integer> z; 
		
		z = (BTNode<Integer>) t3.addRoot(4); 

		t3.insertLeft(z, 9);
		t3.insertLeft(z.getLeft(),7);
		t3.insertRight(t3.left(z),10);
		
		
		t3.insertRight(z, 20);
		t3.insertLeft(t3.right(z), 15);
		t3.insertRight(t3.right(z),21);
		
		t3.insertLeft(z.getRight().getLeft(),12);
		t3.insertRight(z.getRight().getLeft(),17);
		t3.insertLeft(z.getRight().getLeft().getRight(),19);
		
		t3.insertRight(z.getRight().getRight(),40);
		t3.insertLeft(z.getRight().getRight().getRight(),30);
		t3.insertRight(z.getRight().getRight().getRight(), 45);
		
		showTreeElements(t3); 
		
		t3.makeEmpty(); 
		
		
		//BFS
		LinkedBinaryTreeBFS<Integer> t4 = new LinkedBinaryTreeBFS<Integer>(); 
		BTNode<Integer> a; 
		
		a = (BTNode<Integer>) t4.addRoot(4); 
	
		t4.insertLeft(a, 9);
		t4.insertLeft(a.getLeft(),7);
		t4.insertRight(t4.left(a),10);
		
		
		t4.insertRight(a, 20);
		t4.insertLeft(t4.right(a), 15);
		t4.insertRight(t4.right(a),21);
		
		t4.insertLeft(a.getRight().getLeft(),12);
		t4.insertRight(a.getRight().getLeft(),17);
		t4.insertLeft(a.getRight().getLeft().getRight(),19);
		
		t4.insertRight(a.getRight().getRight(),40);
		t4.insertLeft(a.getRight().getRight().getRight(),30);
		t4.insertRight(a.getRight().getRight().getRight(), 45);
		
		showTreeElements(t4); 
		
		//With Stack implementation
		LinkedBinaryTreeStack<Integer> t5 = new LinkedBinaryTreeStack<Integer>(); 
		BTNode<Integer> b; 
		
		b = (BTNode<Integer>) t5.addRoot(4); 
	
		t5.insertLeft(b, 9);
		t5.insertLeft(b.getLeft(),7);
		t5.insertRight(t5.left(b),10);
		
		
		t5.insertRight(b, 20);
		t5.insertLeft(t5.right(b), 15);
		t5.insertRight(t5.right(b),21);
		
		t5.insertLeft(b.getRight().getLeft(),12);
		t5.insertRight(b.getRight().getLeft(),17);
		t5.insertLeft(b.getRight().getLeft().getRight(),19);
		
		t5.insertRight(b.getRight().getRight(),40);
		t5.insertLeft(b.getRight().getRight().getRight(),30);
		t5.insertRight(b.getRight().getRight().getRight(), 45);
		
		showTreeElements(t5); 
		
		
		
	}
	
	/**
	 * Shows the elements in a particular tree based on the available
	 * iterator for the particular type of tree....
	 * @param t the tree to traverse...
	 */
	private static void showTreeElements(Tree<Integer> t) { 
		System.out.println("The tree has "+ t.size() + " elements. These are: "); 
		for (Integer e : t)
			System.out.print(e + " ");
		System.out.println(); 
	}

}
