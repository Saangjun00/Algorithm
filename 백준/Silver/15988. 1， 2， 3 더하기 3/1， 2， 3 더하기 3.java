import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long mod = 1000000009;

        long[] dp = new long[1000001];
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3

        for(int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n] % mod).append("\n");
        }

        System.out.println(sb);;
    }
}
