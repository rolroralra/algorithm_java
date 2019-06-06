package algorithm;
import java.util.Collection;


public class Stack_byArray<E> {
	private Object[] stackArray;
	private int top;
	private int maxSize;
	private static final int DEFAULT_ARRAY_SIZE = 10;
	 
	
	public Stack_byArray() {
		top = -1;
		maxSize = DEFAULT_ARRAY_SIZE;
		stackArray = new Object[maxSize];
	}
	
	public Stack_byArray(int maxSize) {
		top = - 1;
		this.maxSize = maxSize;
		stackArray = new Object[maxSize];
	}
	
	public Stack_byArray(Collection<E> collection) {
		if (collection.size() > DEFAULT_ARRAY_SIZE) {
			stackArray = new Object[collection.size() * 2];
			System.arraycopy(collection.toArray(), 0, stackArray, 0, collection.size());
		}
	}
	
	
}
