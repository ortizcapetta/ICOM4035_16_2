package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeInterfaces.Position;


public class ClonableTesterExercise7 {
	//EXERCISE 7
	public static void main(String[] args) throws CloneNotSupportedException { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		t.addRoot(4);
		t.addLeft(t.root(), 3);
		Position<Integer> pos2 = t.addRight(t.root(),2);
		t.addLeft(pos2,5);
		Position<Integer> ptr =t.addRight(pos2, 4);
		
		

		Utils.displayTree("The binary tree t is : ", t);
		
		LinkedBinaryTree<Integer> y;
		
			y = t.clone();  //new clone method implemented for LinkedBinaryTree class
			Utils.displayTree("The clone of t is ", y);
		
		
		t.remove(ptr);
		
		Utils.displayTree("Tree after removing 4 :", t);
		Utils.displayTree("Clone of the original t is : ", y);
		
	}
                                                     
}
