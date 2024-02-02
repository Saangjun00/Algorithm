import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long result = 1;

        // 팩토리얼 구하기
        for(int i = 1; i <= n; i++) {
            result *= i;
        }

        sb.append(result);

        System.out.println(sb);
    }
}
