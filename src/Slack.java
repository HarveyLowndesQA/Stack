public class Slack<T> implements Stackable<T> {

	private int max;
	
	private T[] stack;
	private int count;
	
	@SuppressWarnings("unchecked")
	public Slack(int max) {
			this.setMax(max);
			setStack((T[]) new Object[max]);
	}

	public void printArr() {
		for(int i = 0; i < stack.length; i++)
			System.out.println(stack[i]);
	}
	
	private void setStack(T[] stack) {
		this.stack = stack;
	}
	
	private void setMax(int max) throws RuntimeException {
		try {
			if(max > 0)
				this.max = max;
			else
				throw new IllegalArgumentException("Stacker max value must be more than 0");
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void push(T data) throws RuntimeException {
		@SuppressWarnings("unchecked")
		T tmp[] = (T[]) new Object[max];
		if(count < max) {
			for(int i = 1; i < stack.length; i++) {
				tmp[i] = stack[i-1];
			}
			tmp[0] = data;
			stack = tmp;
			count++;
		} else {
			throw new StackOverflowError("Overflow");
		}
	}

	@Override
	public T pop() {
		if(count > 0) {
			T popped = stack[0];
			@SuppressWarnings("unchecked")
			T tmp[] = (T[]) new Object[max];
			for(int i = 1; i < stack.length; i++) {
				tmp[i-1] = stack[i];
			}
			stack = tmp;
			count--;
			return popped;
		} else {
			throw new StackUnderflowError("Underflow");
		}
	}

	@Override
	public T peek() {
			if(count > 0) {
				return stack[0];
			} else {
				throw new StackUnderflowError("Underflow");
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		setStack((T[]) new Object[max]);
		count = 0;
	}

}
