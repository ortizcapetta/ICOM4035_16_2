package positionTree;

import QueueStackClasses.LLStack;
import positionInterfaces.Position;
import positionListLLDirect.NodePositionList;

public class LinkedBinaryTreeStack<E> extends LinkedBinaryTree<E> {

	protected void fillIterator(TreeNode<E> r, NodePositionList<Position<E>> list) {
		BTNode<E> rbtn = (BTNode<E>) r;  //root
		LLStack<BTNode<E>> BTNodeStack= new LLStack<>();
		BTNodeStack.push(rbtn);
		
		
	while(!BTNodeStack.isEmpty()){
			rbtn = BTNodeStack.pop();
			
			
			
			BTNode<E> leftNode = (BTNode<E>) rbtn.getLeft(); //creates nodes for each side of the binary tree
			BTNode<E> rightNode = (BTNode<E>) rbtn.getRight();
			
			if(leftNode!=null) BTNodeStack.push((BTNode<E>) leftNode);
			if(rightNode!=null) BTNodeStack.push((BTNode<E>) rightNode);
			list.addLast(rbtn);
		}
		
	}
}

