import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;   // 1
        dp[2][2] = 1;   // 2
        dp[3][1] = 1;   // 2+1
        dp[3][2] = 1;   // 1+2
        dp[3][3] = 1;   // 3

        // 4 = dp[4][1] + dp[4][2] + dp[4][3]
        // dp[4][1] = dp[3][2] + dp[3][3]   -> 3을 이용해서 4를 만드는 방법의 수
        // dp[4][2] = dp[2][1] + dp[2][3]   -> 2를 이용해서 4를 만드는 방법의 수
        // dp[4][3] = dp[1][2] + dp[1][2]   -> 1을 이용해서 4를 만드는 방법의 수
        
        for(int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = 0;
            
            result = (dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009;
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}
