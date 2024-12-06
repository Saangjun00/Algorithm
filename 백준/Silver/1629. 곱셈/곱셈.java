import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken()); 

        long result = func(A, B, C);

        sb.append(result);
        System.out.println(sb);
    }

    private static long func(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long temp = func(A, B / 2, C) % C;

        if (B % 2 == 0) {
            return (temp * temp) % C;
        }

        else {
            return (temp * temp % C) * (A % C) % C;
        }
    }
}
