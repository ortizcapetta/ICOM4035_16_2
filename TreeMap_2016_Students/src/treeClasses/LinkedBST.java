package treeClasses;

import java.util.Comparator;

import positionalStructures.Position;

/**
 * Implementation of the Binary Search Tree as a linked structure. The 
 * approach is to implement it as a subclass of LinkedBinaryTree. That
 * way, we will be able to reuse code from the LinkedBinaryTree, and 
 * from the AbstractTree classes. 
 * 
 * Here, each node holds an element of type E. Data type E represents 
 * a valid object data type satisfying an order relation compatible with
 * the comparator that is received by any created instance of the BST. 
 * 
 * 
 * @author pedroirivera-vega
 *
 * @param <E>
 */
public class LinkedBST<E> extends LinkedBinaryTree<E> {
	// The comparator that defines the order relation satisfied by objects of type E
	private Comparator<E> cmp; 

	/**
	 * The constructor.
	 * @param cmp the comparator
	 */
	public LinkedBST(Comparator<E> cmp) { 
		super();         // invoke default constructor of LinkedBinaryTree
		// to initialize inherited components

		this.cmp = cmp;  // the comparator
	}

	/**
	 * Adds a new element of type E to the tree. After insertion, the tree must continue being a bst. 
	 * In this case, elements in the bst can be repeated. A new position will be eventually created 
	 * holding the new element, and that node is then inserted at the correct location in the tree. 
	 * 
	 * @param e the new element
	 */
	public void addElement(E e) { 
		if (isEmpty()) addRoot(e);    // in this case, the new position will become the root,  
		// and the only node of the tree		           
		else recInsert(root(), e);      // in this case, traverse the tree in search of the right
		// location where to put the new element’s position
	}


	/**
	 * Internal private method. 
	 * Recursively look for the location where the new position with element e is to be inserted. 
	 * That new position will be inserted as a new leaf of the binary tree. 
	 * @param r root of the subtree where the insertion will take place.
	 * 
	 * @param e the new element to be added to the tree in a new position
	 */
	private void recInsert(Position<E> r, E e) {
		int c = cmp.compare(e, r.getElement()); 
		if (c < 0) 
			if (!hasLeft(r))
				addLeft(r, e); 
			else 
				recInsert(left(r), e); 
		else 
			if (!hasRight(r))
				addRight(r, e); 
			else 
				recInsert(right(r), e); 		
	}

	/**
	 * Internal private method. 
	 * Search for a position whose element matches the element being searched for
	 * @param r the root of the subtree where the search is done
	 * @param e the element to search for. This parameter refers to an object of type E 
	 * which have at least enough information to be able to compare with existing elements
	 * in the tree and distinguish which element in the tree matches the search.
	 * @return reference to a position in the tree containing a matching element. If none is 
	 * found, then it returns null. 
	 */
	private Position<E> findPosition(Position<E> r, E e) { 
		if (r == null) return null; 
		int c = cmp.compare(e, r.getElement()); 
		if (c == 0) return r; 
		if (c < 0) return findPosition(left(r), e); 
		return findPosition(right(r), e);
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public Position<E> getPosition(E e) { 
		return findPosition(root(), e); 
	}

	/**
	 * Removes element e from the tree, and also one position. The
	 * position being removed is not necessarily the same position 
	 * where e is located. But the only element to be removed is e
	 * and the tree will continue satisfying the binary search tree
	 * fundamental property. 
	 * 
	 * @param e the element to be removed. It is presumed that e 
	 * contains at least whatever internal data is necessary
	 * to successfully compare with existing objects. 
	 *  
	 * @return the whole version of e as contained in the tree
	 * if it is the case that a matching element is found, and
	 * successfully removed. If no element is found, it returns null. 
	 */
	public E removeElement(E e) { 
		Position<E> pos = findPosition(root(), e); 


		if (pos == null) return null; 

		// Element To Return, the actual element in the tree that matches the searh criteria
		E etr = pos.getElement(); 

		// Initiate the action to delete a position. The position finally deleted will be pos, only 
		// if pos has at most one child; otherwise, if pos has more than one child, the position to be 
		// finally removed will be the position containing the element that immediately follows element e
		// in order in the tree (the successor of e in the tree). That successor element will be moved to 
		// position pos, replacing the value there; which is the value to delete! ...
		deletePosition(pos); 

		return etr;     // returns a full copy of e as it is in the tree.
	}


	/**
	 * Internal private method. 
	 * Initiate the removal of a position. 
	 * @param pos
	 */
	private void deletePosition(Position<E> pos) {
		if (left(pos) == null || right(pos) == null) { 
			// In this case, position pos has at most one child. Hence, pos itself
			// will be the position removed from the tree. For that, just apply the
			// remove operation that is inherited from LinkedBinaryTree. 
			remove(pos);       // inherited from LinedBinaryTree (see remove in that class)
		}
		else {
			// pos has two children. Find the position containing the element
			// in the tree that, in the order given, should go immediately after
			// the element in pos. In this case, that element is the minimum 
			// element in the right subtree of pos. 
			Position<E> smallest = findSmallestPosition(right(pos));  

			// smallest is now the position in the tree that contains the
			// successor of pos.getElement(). Note that by property of the
			// binary search tree, position smallest has no left child; it
			// has at most only a right child. 

			// copy that successor element to position pos. 
			pos.setElement(smallest.getElement());

			// apply the inherited method from LinkedBinaryTree to remove position
			// smallest. Since smallest has at most only one child (the right child), 
			// the remove should work without any problem (See remove method in class
			// LinkedBinaryTree.
			remove(smallest);   // remove method that is inherited from LinkedBinaryTree
		}
	}


	/**
	 * Internal private method. 
	 * Find the smallest element in the binary search tree whose
	 * root is given. It is assumed the the tree is not empty.
	 * 
	 * @param r the root of the tree (or subtree) to explore. 
	 * PRE: r != null  
	 * 
	 * @return reference to the position in the tree with root
	 * r containing the smallest element in that subtree. Notice
	 * that to find such position we just need to move, beginning
	 * at r, all the way to the left until we find the first node  
	 * that does not have left child. That node will contain the
	 * smallest element in the binary search tree rooted a r. 
	 * This is so because of the binary search tree property. 
	 */
	private Position<E> findSmallestPosition(Position<E> r) {
		while (left(r) != null) 
			r = left(r); 
		return r;
	}
}