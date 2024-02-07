import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static Integer[] dp;    // 메모이제이션 할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        sb.append(recur(N));

        System.out.println(sb);
    }

    // 최소 연산 횟수를 찾는 재귀함수
    private static int recur(int N) {
        if(dp[N] == null) {
            // 6으로 나눠지는 경우
            if(N % 6 == 0) {
                dp[N] = Math.min(Math.min(recur(N / 3), recur(N / 2)), recur(N - 1)) + 1;
            }
            // 3으로만 나눠지는 경우
            else if(N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2만 나눠지는 경우
            else if(N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나눠지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }

        return dp[N];
    }
}
