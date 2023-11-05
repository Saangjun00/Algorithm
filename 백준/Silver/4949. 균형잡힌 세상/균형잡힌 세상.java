import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		String str = "";
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			
			str = br.readLine();
			boolean isBalanced = true;
			
			if(str.equals(".")) {
				break;
			}
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				
				else if(c == ')') {
					if(stack.empty() || stack.peek() != '(') {
						isBalanced = false;
						break;
					}
					else {
						stack.pop();
					}
				}
				
				else if(c == ']') {
					if(stack.empty() || stack.peek() != '[') {
						isBalanced = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			
			if(!stack.empty()) {
				isBalanced = false;
			}
			
			if(isBalanced) {
				sb.append("yes").append("\n");
			}
			else {
				sb.append("no").append("\n");
			}
			}
		System.out.println(sb);
	}

}
