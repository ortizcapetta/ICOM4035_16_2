package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class ExampleTreeBuilder1 {

	public static void main(String[] args) {
		LinkedTree<Integer> t = Utils.buildExampleTreeAsLinkedTree(); 

		// display content as a tree
		Utils.displayTree("The tree is: ", t); 
		
		/**EXERCISE 3:  c) The reason you see the output as in figure 1 because
		 * the recDisplay method in AbstractBinaryTree doesn't do anything on a LinkedTree
		 * since the AbstractTree method is the one that is being overwritten for the
		 * LinkedBinaryTree
		 */
		
		
		
	}

}
