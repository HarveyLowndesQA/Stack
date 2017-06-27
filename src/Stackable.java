
public interface Stackable<T> {
	
	public void push(T data);
	
	public T pop();
	
	public T peek();
	
	public void clear();

}
