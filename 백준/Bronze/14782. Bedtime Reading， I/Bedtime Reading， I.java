import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                answer += i;
            }
        }

        sb.append(answer);

        System.out.println(sb);
    }
}
