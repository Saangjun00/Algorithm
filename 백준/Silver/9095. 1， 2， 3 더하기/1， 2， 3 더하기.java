import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static Integer[] dp;    // 메모이제이션 할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            dp = new Integer[n + 4];


            sb.append(plus123(n)).append("\n");
        }

        System.out.println(sb);
    }

    // 1, 2, 3을 이용하여 n의 합으로 나타내는 함수
    private static int plus123(int n) {
        if(dp[n] == null) {
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }
}
