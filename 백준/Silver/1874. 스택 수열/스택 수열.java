import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int top = 0;
		
		while(n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > top) {
				for(int i = top + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				
				top = num;
			}
			else if(stack.peek() != num) {
				sb.setLength(0);
				sb.append("NO").append("\n");
				break;
			}
			
			stack.pop();
			sb.append("-").append("\n");
			
		}
		
		
		System.out.println(sb);
	}

}
