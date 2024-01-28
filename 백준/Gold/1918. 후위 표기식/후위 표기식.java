import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String data = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);

            // 연산자 제외 바로 출력
            if('A' <= ch && 'Z' >= ch) {
                sb.append(ch);
            }
            else if(ch == '(') {
                stack.push(ch);
            }
            // 닫는 괄호 나오면 여는 괄호 나올때까지 출력
            else if(ch == ')') {
                while(!stack.empty()) {
                    if(stack.peek() == '(') {   //여는 괄호 삭제
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }
            // 연산자를 스택에 넣을 때 이미 현재 연산자보다 우선순위가 더 높거나 같으면 빼주고 스택에 넣음
            else {
                while(!stack.empty() && priority(stack.peek()) >= priority(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
            
        }

        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }

    // 우선순위 지정함수
    static int priority(char ch) {
        if(ch == '(') return 0;
        else if(ch == '+' || ch == '-') return 1;
        else return 2;
    }
}
