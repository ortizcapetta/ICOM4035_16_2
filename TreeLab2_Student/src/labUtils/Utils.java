package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
		
		//EXERCISE 2
		t.addRoot(4);
		Position<Integer> Pos9 = t.addChild(t.root(),9);
		t.addChild(Pos9,7);
		t.addChild(Pos9, 10);
		
		Position <Integer> Pos20 = t.addChild(t.root(), 20);
		Position <Integer> Pos15 = t.addChild(Pos20, 15);
		Position <Integer> Pos21 = t.addChild(Pos20,21);
		
		t.addChild(Pos15,12);
		Position <Integer> Pos17 =t.addChild(Pos15, 17);
		t.addChild(Pos17, 19);
		
		Position <Integer> Pos40 =t.addChild(Pos21, 40);
		t.addChild(Pos40,30);
		t.addChild(Pos40, 45);
	
		
		
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		t.addRoot(4);
		Position<Integer> Pos9 = t.addLeft(t.root(),9);
		t.addLeft(Pos9,7);
		t.addRight(Pos9, 10);
		
		Position <Integer> Pos20 = t.addRight(t.root(), 20);
		Position <Integer> Pos15 = t.addLeft(Pos20, 15);
		Position <Integer> Pos21 = t.addRight(Pos20,21);
		
		t.addLeft(Pos15,12);
		Position <Integer> Pos17 =t.addRight(Pos15, 17);
		t.addLeft(Pos17, 19);
		
		Position <Integer> Pos40 =t.addRight(Pos21, 40);
		t.addLeft(Pos40,30);
		t.addRight(Pos40, 45);
		
		
		return t; 
	}


}
