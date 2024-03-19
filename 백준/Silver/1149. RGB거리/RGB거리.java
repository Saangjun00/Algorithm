import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private final static int Red = 0;
    private final static int Green = 1;
    private final static int Blue = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            dp[i][Red] = Integer.parseInt(st.nextToken());
            dp[i][Green] = Integer.parseInt(st.nextToken());
            dp[i][Blue] = Integer.parseInt(st.nextToken());
        }

        // 1부터 N-1까지 서로 다른 색상 중 최솟값을 누적 합 구하기
        for(int i = 1; i < N; i++) {
            dp[i][Red] += Math.min(dp[i - 1][Green], dp[i - 1][Blue]);
            dp[i][Green] += Math.min(dp[i - 1][Red], dp[i - 1][Blue]);
            dp[i][Blue] += Math.min(dp[i - 1][Red], dp[i - 1][Green]);
        }

        sb.append(Math.min(Math.min(dp[N - 1][Red], dp[N - 1][Green]), dp[N - 1][Blue]));

        System.out.println(sb);
    }
}
