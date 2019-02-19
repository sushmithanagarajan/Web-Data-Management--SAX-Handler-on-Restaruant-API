import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		
		String string1 = "<><><<<";
		int maxReplacement1 = 2;
		Character tempChar;
		
		Stack<Character> myStack = new Stack<>();
		
		for(char ch : string1.toCharArray()) {
			if(ch == '<') {
				myStack.push(ch);
				System.out.println("In first condition");
			} else if(ch == '>') {
				System.out.println("In second condition");
				if(myStack.size() > 0) {
					tempChar = myStack.peek();
					if(tempChar == '<') {
						myStack.pop();
						System.out.println(myStack);
					} else {
						myStack.push(ch);
						System.out.println(myStack);
					}
				} else {
					myStack.push(ch);
					System.out.println(myStack);
				}
			}
		}
		
		int stackLength = myStack.size();
		System.out.println();
		System.out.println("The lenght of stack is : " +myStack.size());
		
		if(stackLength <= maxReplacement1)
			System.out.println("String is stable");
		else 
			System.out.println("String is unstable");
	}

}
