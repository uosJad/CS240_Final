package Final;
import Ds.NoNextElementException;
import Ds.QueueInterface;

/**
 * Takes in an array copy of a Queue and iterates
 * @author Jason Wu
 *
 * @param <T>
 */
public class IteratorQueue<T> implements Iterator<T> {
	private T[] arr;
	private int curr;

	public IteratorQueue(QueueInterface<T> l){
		arr = l.toArray();
		curr = -1;
	}
	
	@Override
	public boolean hasNext() {
		boolean r = false;
		if (curr + 1 < arr.length && arr[curr + 1] != null){
			r = true;
		}
		return r;
	}

	@Override
	public T next() {
		T temp = null;
		try{
			if (hasNext()){
				temp = arr[curr+1];
				curr++;
			}
			else throw new NoNextElementException("No Next Element");
		} 
		catch (NoNextElementException e){
		}
		return temp;
	}
	
	
	
}
