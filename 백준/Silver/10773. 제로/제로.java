import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(br.readLine());
		int result = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				result -= stack.pop();
			}
			else {
				result += stack.push(num);
			}
		}
		
		sb.append(result);
		System.out.println(sb);

	}

}
