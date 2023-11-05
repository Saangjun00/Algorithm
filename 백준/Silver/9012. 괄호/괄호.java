import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			boolean isVPS = true;
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '(') {
					stack.push(c);
				}
				else if(c == ')') {
					if(stack.empty()) {
						isVPS = false;
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			
			if(!stack.empty()) {
				isVPS = false;
			}
			
			if(isVPS) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb);
	}

}
