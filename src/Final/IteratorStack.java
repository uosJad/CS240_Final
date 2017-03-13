package Final;
import Ds.NoNextElementException;
import Ds.StackInterface;

public class IteratorStack<T> implements Iterator<T> {
	private T[] arr;
	private int curr;

	public IteratorStack(StackInterface<T> l){
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
