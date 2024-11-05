import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());        // 계단의 개수

        int[] score = new int[n + 1];
        for (int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];        // 최대 계단의 개수

        // 계단의 개수가 1개인 경우
        if (n == 1) {
            sb.append(score[1]);
        }

        // 계단의 개수가 2개인 경우
        else if (n == 2) {
            sb.append(score[1] + score[2]);
        }

        // 계단의 개수가 3개 이상인 경우
        else {
            dp[1] = score[1];
            dp[2] = score[1] + score[2];
            dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(score[i] + score[i - 1] + dp[i - 3], score[i] + dp[i - 2]);
            }

            sb.append(dp[n]);
        }
        

        System.out.println(sb);
    }
}
