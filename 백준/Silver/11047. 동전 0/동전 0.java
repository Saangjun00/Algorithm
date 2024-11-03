import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 가지고 있는 종류의 수
        int K = Integer.parseInt(st.nextToken());       // 가치의 합

        int[] coin = new int[N];
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = coin.length - 1; i >= 0; i--) {
            if (K >= coin[i]) {
                if (K % coin[i] < coin[i]) {
                    result += K / coin[i];
                    K %= coin[i];
                }
            }
        }

        sb.append(result);

        System.out.println(sb);
    }
}
