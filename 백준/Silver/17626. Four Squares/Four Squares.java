import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[50001];
        dp[1] = 1;      // 1은 1*1로 표현되므로 1

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;      // 최댓값으로 초기화하여 최솟값을 찾음

            for (int j = 1; j * j <= i; j++) {
                // j*j 제곱수를 하나 사용하기 때문에 +1을 해줌
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        sb.append(dp[n]);

        System.out.println(sb);
    }
}
