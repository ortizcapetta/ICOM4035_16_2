package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester3 {

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(); 
		
		// display content as a tree
		Utils.displayTree("The original binary tree is: ", t); 


		// build the same tree but as a general tree....
		LinkedTree<Integer> t2 = Utils.buildExampleTreeAsLinkedTree(); 
		Utils.displayTree("Same tree as a general tree is: ", t2); 
		/**
		 * Exercise 3: d) They are different but the same because
		 * one is built as a Linked Tree and the other one is built as a Linked Binary Tree
		 * The main difference is that LinkedBinaryTree extends AbstractBinaryTree who's recDisplay
		 * method overrides that one found in AbstractTree which the LinkedTree class uses
		 */
	}

}
