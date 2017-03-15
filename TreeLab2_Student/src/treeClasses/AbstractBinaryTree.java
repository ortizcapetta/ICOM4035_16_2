package treeClasses;

import java.util.ArrayList;
import java.util.Iterator;
import treeInterfaces.BinaryTree;
import treeInterfaces.Position;

/**
 * Partial implementation of the BinaryTree ADT.
 * 
 * @author pedroirivera-vega
 *
 * @param <E> The generic data type of elementsin the heap
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements
		BinaryTree<E> {

	@Override
	public Iterable<Position<E>> children(Position<E> p)
			throws IllegalArgumentException {
		ArrayList<Position<E>> list = new ArrayList<>(); 
		if (this.hasLeft(p)) list.add(this.left(p)); 
		if (this.hasRight(p)) list.add(this.right(p));
		
		return list;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0; 
		if (this.hasLeft(p)) count++; 
		if (this.hasRight(p)) count++; 
		return count;
	}

	@Override
	public boolean hasLeft(Position<E> p) throws IllegalArgumentException {
		return this.left(p) != null;
	}

	@Override
	public boolean hasRight(Position<E> p) throws IllegalArgumentException {
		return this.right(p) != null;
	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = this.parent(p); 
		if (parent == null) 
			return null; 
		if (this.left(parent) == p)
			return this.right(parent); 
		return this.left(parent);
	}
	

	
	//EXERCISE 3
	
	protected void recDisplay(Position<E> root,                          
			int[] control, int level)                                    
	{                                                                    
		printPrefix(level, control);                                     
		System.out.println();                                            
		printPrefix(level, control);  
		String prefix = "";
		Position<E> parent = this.parent(root);
		if(parent==null){
			prefix="ROOT";
		}else if(this.left(parent) == root){
			prefix ="L";
		}else prefix ="R";
		
			
		System.out.println("__" + prefix + "("+root.getElement()+")");                 
		control[level]--;                                                
		int nc = this.numChildren(root);                                 
		control[level+1] = nc;                                           
		for (Position<E>  p : this.children(root)) {                     
			recDisplay(p, control, level+1);                             
		}   
	}


	//EXCERSIE 5
	
	// internal method to construct the Iterable<Position<E>> object. 
	// based on inorder traversal. 
	protected void fillIterable(Position<E> r, ArrayList<Position<E>> pList) { 
		if (hasLeft(r)) 
			fillIterable(left(r), pList); 
		pList.add(r); 
		if (hasRight(r)) 
			fillIterable(right(r), pList); 
	}
    


}
