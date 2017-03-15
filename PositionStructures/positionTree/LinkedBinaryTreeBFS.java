package positionTree;

import QueueStackClasses.LLQueue;
import positionInterfaces.Position;
import positionListLLDirect.NodePositionList;

public class LinkedBinaryTreeBFS<E> extends LinkedBinaryTree<E> {

	protected void fillIterator(TreeNode<E> r, NodePositionList<Position<E>> list) {
		BTNode<E> rbtn = (BTNode<E>) r;  //root
		LLQueue<BTNode<E>> BTNodeQueue = new LLQueue<>();
		BTNodeQueue.enqueue(rbtn);
		
		
	while(!BTNodeQueue.isEmpty()){
			rbtn = BTNodeQueue.dequeue();
			
			
			
			BTNode<E> leftNode = (BTNode<E>) rbtn.getLeft(); //creates nodes for each side of the binary tree
			BTNode<E> rightNode = (BTNode<E>) rbtn.getRight();
			
			if(leftNode!=null) BTNodeQueue.enqueue((BTNode<E>) leftNode);
			if(rightNode!=null) BTNodeQueue.enqueue((BTNode<E>) rightNode);
			list.addLast(rbtn);
		}
		
	}
}

