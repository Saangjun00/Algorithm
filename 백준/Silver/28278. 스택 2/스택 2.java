import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] str = br.readLine().split(" ");
            int cmd = Integer.parseInt(str[0]);

            if (cmd == 1) {
                stack.push(Integer.parseInt(str[1]));
            }

            else if (cmd == 2) {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                }

                else {
                    sb.append(stack.pop()).append("\n");
                }
            }

            else if (cmd == 3) {
                sb.append(stack.size()).append("\n");
            }

            else if (cmd == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                }

                else {
                    sb.append(0).append("\n");
                }
            }

            else {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                }

                else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
