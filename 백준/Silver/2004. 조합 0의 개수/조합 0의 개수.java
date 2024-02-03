import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 5와 2의 겹치는 승수를 구함
        int count5 = power_count(n, 5) - power_count(m, 5) - power_count(n - m, 5);
        int count2 = power_count(n, 2) - power_count(m, 2)- power_count(n - m, 2);

        // 5와 2의 승수 중 최솟값
        sb.append(Math.min(count5, count2));

        System.out.println(sb);
    }

    // 승수 구하는 함수
    private static int power_count(long num, int k) {
        int count = 0;

        while(num >= k) {
            count += num / k;
            num /= k;
        }

        return count;
    }
}
