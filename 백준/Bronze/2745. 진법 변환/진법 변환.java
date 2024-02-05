import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        // B진수 -> 10진수 변환
        int result = Integer.parseInt(N, B);
        
        sb.append(result);

        System.out.println(sb);
    }
}
