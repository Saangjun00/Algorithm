import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // OI 패턴 길이
        int M = Integer.parseInt(br.readLine());        // 문자열 길이
        String str = br.readLine();

        int count = 0;
        int result = 0;

        for (int i = 1; i < M - 1; i++) {
            if (str.charAt(i - 1) == 'I' && str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                count++;

                if (count == N) {
                    result++;
                    count--;
                }
                i++;
            }

            else {
                count = 0;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}
