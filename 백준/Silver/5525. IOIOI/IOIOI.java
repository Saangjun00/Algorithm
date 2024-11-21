import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // IOI 패턴 길이
        int M = Integer.parseInt(br.readLine());        // 문자열 길이
        String str = br.readLine();

        String P = "I";     // 패턴
        for (int i = 0; i < N; i++) {
            P += "OI";
        }

        int count = 0;

        for (int i = 0; i <= M - P.length(); i++) {
            if (str.substring(i, i + P.length()).equals(P)) {
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
}
