import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long mod = 1000000000;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + 1][K + 1];
        for(int i = 0; i < N + 1; i++) {
            dp[i][1] = 1;       // 정수 1개를 더해서 i를 만드는 경우의 수는 1개
        }

        for(int i = 1; i < K + 1; i++) {
            dp[0][i] = 1;       // 정수 0을 i개를 사용하여 0을 만드는 경우의 수는 1개
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        sb.append(dp[N][K] % mod);

        System.out.println(sb);
    }
}
