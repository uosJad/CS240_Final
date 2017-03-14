package Final;
import Ds.ListInterface;
import Ds.ListNode;

public class IteratorOfIterators{
	private ListInterface<Iterator> itList;
	private Iterator<Iterator> it;
	
	public IteratorOfIterators(){
		itList = new ListNode<Iterator>();
	}
	
	/**
	 * add iterator to list. add in oder to iterate
	 * @param i
	 */
	public void addIterator(Iterator i) {
		itList.add(i);
	}
	
	public void iterateThrough(){
		try{
			if (it != null){
				//iterates through iterators
				while (it.hasNext()){
					Iterator curr = it.next();
					while(curr.hasNext()){
						System.out.println(curr.next());
					}
				}
			}
			else{
				throw new Exception("No iterator generarted");
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Generates internal iterator. Call after adding all iterators
	 */
	public void generateIterator(){
		it = new IteratorList<Iterator>(this.itList);
	}
	
	public boolean hasNext(){
		return it.hasNext();
	}
	
}
