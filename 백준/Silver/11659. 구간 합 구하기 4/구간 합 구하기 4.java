import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 수의 개수
        int M = Integer.parseInt(st.nextToken());       // 합을 구해야 하는 횟수

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        int prev = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = prev + arr[i];
            prev += arr[i];
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = dp[b] - dp[a - 1];
            
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
