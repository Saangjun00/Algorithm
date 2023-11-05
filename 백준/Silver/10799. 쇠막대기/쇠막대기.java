import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		int result = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			}
			else if(str.charAt(i) == ')') {
				stack.pop();
				
				if(str.charAt(i - 1) == '(') {
					result += stack.size();
				}
				else {
					result++;
				}
			}
		}
		
		sb.append(result);
		System.out.println(sb);
		
	}

}
