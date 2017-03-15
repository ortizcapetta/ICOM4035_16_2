package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester4 {

	public static void main(String[] args) { 
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(); 

		// display content as a tree
		Utils.displayTree("The structure of the tree is: ", t);
		
		// display elements as a list
		Utils.displayTreeElements("The elements of the tree are: ", t);
		
		/**
		 * EXERCISE 5:
		 * 	After changing the fillIterable method in AbstractBinaryTree, 
		 * 	the traversal was inorder 
		 * 	before adding this new method, the traversal was preorder because it was the one established in the AbstractTree class
		 *  by creating this new fillIterable method in the AbstractBinaryTree class, we overwrite the one created by the more general class
		 *
		 */
		
	}

}
