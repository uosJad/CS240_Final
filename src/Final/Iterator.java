package Final;

/**
 * Iterates through datas ctuctures
 * @author Jason Wu
 *
 * @param <T> type of values iterating through
 */
public interface Iterator<T> {

	/**
	 * Checks to see if there is a non null entry after the current position
	 * @return true if entry, else false
	 */
	public boolean hasNext();
	
	/**
	 * Iterates one and returns the value iterated over if has next
	 * otherwise return null
	 * @return next value
	 */
	public T next();
	
}
