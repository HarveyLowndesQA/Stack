
public class Main {

	
	public static void main(String[] args) {
		
		Slack<Integer> myStack = new Slack<Integer>(4);
		
		myStack.push(50);
		myStack.push(40);
		myStack.push(90);
		myStack.push(20);
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
		System.out.println(myStack.peek());
		
	}
	
}
