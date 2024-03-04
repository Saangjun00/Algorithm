import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int maxIndex = 0;
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            // dp배열 초기화
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        sb.append(max).append("\n");

        // 수열 구하기
        Stack<Integer> stack = new Stack<>();
        for(int i = maxIndex; i >= 0; i--) {
            if(dp[i] == max && (stack.isEmpty() || arr[i] < stack.peek())) {
                stack.push(arr[i]);
                max--;
            }
        }

        // 스택에 있는 값 빼기
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
