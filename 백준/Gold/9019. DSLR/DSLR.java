import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());        // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            visited[A] = true;

            Queue<Register> queue = new LinkedList<>();
            queue.offer(new Register(A, ""));

            while (!queue.isEmpty()) {
                Register current = queue.poll();

                if (current.num == B) {
                    sb.append(current.command).append("\n");
                    break;
                }

                if (!visited[current.D()]) {
                    queue.offer(new Register(current.D(), current.command + "D"));
                    visited[current.D()] = true;
                }

                if (!visited[current.S()]) {
                    queue.offer(new Register(current.S(), current.command + "S"));
                    visited[current.S()] = true;
                }

                if (!visited[current.L()]) {
                    queue.offer(new Register(current.L(), current.command + "L"));
                    visited[current.L()] = true;
                }

                if (!visited[current.R()]) {
                    queue.offer(new Register(current.R(), current.command + "R"));
                    visited[current.R()] = true;
                }
            }
        }

        System.out.println(sb);
    }

    private static class Register {

        int num;
        String command;
    
        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
    
        int D() {
            return (num * 2) % 10000;
        }
    
        int S() {
            return num == 0 ? 9999 : num - 1;
        }
    
        int L() {
            return num % 1000 * 10 + num / 1000;
        }
    
        int R() {
            return num % 10 * 1000 + num / 10;
        }
        
    }
}


