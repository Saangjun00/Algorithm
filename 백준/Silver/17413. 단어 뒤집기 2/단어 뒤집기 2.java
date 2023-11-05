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
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				flag = true;
			}
			else if(str.charAt(i) == '>') {
				flag = false;
				sb.append(str.charAt(i));
				continue;
			}
			
			if(flag == true) {
				sb.append(str.charAt(i));
			}
			else {
				if(str.charAt(i) == ' ') {	// 공백을 만나지 전까지 출력
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				}
				else {
					stack.push(str.charAt(i));	
				}
			}
			
			// 반복문이 마지막일 때 남은 스택 출력
			if(i == str.length() - 1) {
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
			}
		}
		
		System.out.println(sb);
	}

}
