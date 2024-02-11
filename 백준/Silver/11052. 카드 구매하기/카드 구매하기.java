import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        // 카드 i개를 구매할 때
        // 카드 1개가 들어있는 카드팩 구매, 카드 i-1개 구매
        // 카드 2개가 들어있는 카드팩 구매, 카드 i-2개 구매
        // 카드 3개가 들어있는 카드팩 구매, 카드 i-3개 구매
        // dp[i] = arr[N] + dp[i - N]
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        sb.append(dp[N]);
        
        System.out.println(sb);
    }
}
