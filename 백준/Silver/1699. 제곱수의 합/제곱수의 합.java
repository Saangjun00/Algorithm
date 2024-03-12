import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for(int i = 1; i <= N; i++) {
            dp[i] = i;

            for(int j = 1; j <= (int)i/2; j++) {
                if(j*j == i) {
                    dp[i] = 1;
                    break;
                }
                
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        sb.append(dp[N]);

        System.out.println(sb);
    }
}
