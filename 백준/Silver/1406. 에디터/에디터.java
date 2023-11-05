import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String cmd = br.readLine();
			String[] token = cmd.split(" ");
			
			if(token[0].equals("L")) {
				if(!stack.isEmpty()) {
					stack2.push(stack.pop());
				}
				else {
					continue;
				}
			}
			
			if(token[0].equals("D")) {
				if(!stack2.isEmpty()) {
					stack.push(stack2.pop());
				}
				else {
					continue;
				}
			}
			
			if(token[0].equals("B")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					continue;
				}
			}
			
			if(token[0].equals("P")) {
				char newChar = token[1].charAt(0);
				stack.push(newChar);
			}
			
			
		}
		
		while(!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		String reverseStr = sb.reverse().toString();
		
		System.out.println(sb);
	}

}
