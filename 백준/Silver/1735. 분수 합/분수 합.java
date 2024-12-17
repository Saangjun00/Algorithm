import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());       // 분수1 분자
        int B = Integer.parseInt(st.nextToken());       // 분수1 분모

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());       // 분수2 분자
        int D = Integer.parseInt(st.nextToken());      // 분수2 분모

        int numerator = A * D + B * C;
        int denominator = B * D;

        int gcd = gcd(numerator, denominator);

        System.out.println(numerator / gcd + " " + denominator / gcd);
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
