package positionListLLDirect;

import java.util.Iterator;

import exceptionClasses.EmptyListException;
import positionInterfaces.Position;

public class NodePositionListTester {

	public static void main(String[] args) {
		
		NodePositionList<Integer> w = new NodePositionList<Integer> (); 
		NodePositionList<Integer> q = new NodePositionList<Integer> (); 
		q.addFirst(10); 
		
		w.addFirst(5); 
		w.addFirst(3); 
		
		w.addLast(10); 
		w.addLast(13); 
		
		try {
			Position<Integer> p = w.first();
			w.addAfter(p, 2); 
			p = w.next(p); 
			w.addAfter(p, 34); 
			w.addBefore(p, 40); 
			p = w.first();   //changed q to w
			w.addAfter(p, 89); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		showElements(w); 
		
		//For Activity 5
		NodePositionList<Integer> s = new NodePositionList<Integer> ("backwards"); 
		s.addFirst(2);
		s.addFirst(3);
		s.addLast(445);
		Position<Integer> p = s.first();
		s.addAfter(p, 3);
		s.addBefore(p, 4210);
		s.addFirst(23);
		System.out.print("**********");
		showElements(s);
		
	}
	private static <E> void showElements(NodePositionList<E> w) {
		for(E p : w) 
			System.out.println(p); 
	}
	

	

}
