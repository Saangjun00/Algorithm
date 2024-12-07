import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());        // 삼각형의 크기

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 맨 왼쪽일 때
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }

                // 맨 오른쪽일 때
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        // 맨 밑줄에서 최댓값 찾기
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        sb.append(max);
        System.out.println(sb);
    }
}
