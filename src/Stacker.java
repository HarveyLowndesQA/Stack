import java.util.ArrayList;
import java.util.List;

public class Stacker<T> implements Stackable<T> {

	private int max;
	
	private List<T> stack = new ArrayList<T>();
	
	public Stacker(int max) {
		try {
			this.setMax(max);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void push(T data) {
		try {
			add(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(T data) throws Exception {
		if(stack.size() < max)
			stack.add(0, data);
		else
			throw new Exception("Stacker Overflow!");
	}
	
	@Override
	public T pop() {
		T data = stack.get(0);
		stack.remove(0);
		return data;
	}

	@Override
	public T peek() {
		if(stack.isEmpty())
			throw new RuntimeException("Stacker Underflow!");
		return stack.get(0);
	}

	@Override
	public void clear() {
		stack.clear();
	}

	private void setMax(int max) throws Exception {
		if(max > 0)
			this.max = max;
		else
			throw new Exception("Stacker max value must be more than 0");
	}

}
