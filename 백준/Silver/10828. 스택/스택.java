import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
	
	public static Stack<Integer> stack = new Stack<>();
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) { 
			String str = br.readLine();
			String[] token = str.split(" ");
			
			if(token[0].equals("push")) {
				push(Integer.parseInt(token[1]));
			}
			
			if(token[0].equals("pop")) {
				pop();
			}
			
			if(token[0].equals("size")) {
				size();
			}
			
			if(token[0].equals("empty")) {
				empty();
			}
			
			if(token[0].equals("top")) {
				top();
			}
		}
		
		System.out.println(sb);
	}
	
	public static void push(int x) {
		stack.add(x);
	}
	
	public static void pop() {
		if(stack.empty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(stack.pop()).append("\n");
		}
	}
	
	public static void size() {
		sb.append(stack.size()).append("\n");
	}

	public static void empty() {
		if(stack.empty()) {
			sb.append(1).append("\n");
		}
		else {
			sb.append(0).append("\n");
		}
	}
	
	public static void top() {
		if(stack.empty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(stack.peek()).append("\n");
		}
	}
}
