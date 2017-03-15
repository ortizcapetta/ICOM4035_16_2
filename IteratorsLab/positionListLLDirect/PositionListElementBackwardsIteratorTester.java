package positionListLLDirect;

import exceptionClasses.EmptyListException;
import positionInterfaces.Position;

public class PositionListElementBackwardsIteratorTester {

	public static void main(String[] args) {
		
		NodePositionListBackward<Integer> w = new NodePositionListBackward<Integer> (); 
		NodePositionListBackward<Integer> q = new NodePositionListBackward<Integer> (); 
		q.addFirst(10); 
		
		w.addFirst(5); 
		w.addFirst(3); 
		
		w.addLast(10); 
		w.addLast(13); 
		
		try {
			Position<Integer> p = w.first();
			w.addAfter(p, 2); 
			showElements(w);
			p = w.next(p); 
			w.addAfter(p, 34); 
			w.addBefore(p, 40); 
			p = w.first();   //changed q to w
			w.addAfter(p, 89); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		showElements(w); 

	}

	private static <E> void showElements(NodePositionListBackward<E> w) {
		
		for(E p : w) 
			System.out.println(p); 
	}
	


}
