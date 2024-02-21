import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 맨 끝자리가 0일 때 -> 0 또는 1 가능
        // 맨 끝자리가 1일 때 -> 0만 가능
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        sb.append(dp[N]);

        System.out.println(sb);
    }
}
