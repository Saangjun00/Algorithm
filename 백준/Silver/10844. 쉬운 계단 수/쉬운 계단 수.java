import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private final static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        // 첫번째 자리는 경우의 수가 1개
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            // 0으로 시작하는 수의 개수
            dp[i][0] = dp[i - 1][1] % MOD;

            for(int j = 1; j < 10; j++) {
                // 9로 시작하는 수의 경우, 이전 자릿수의 8로 시작하는 수와 동일
                if(j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                }
                // 나머지는 이전 수와 다음 수의 더한 값
                else {
                    dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j + 1] % MOD) % MOD;
                }
            }
        }

        long result = 0;
        for(int i = 1; i < 10; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        sb.append(result);

        System.out.println(sb);
    }
}
