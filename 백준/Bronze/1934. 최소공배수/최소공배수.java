import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[2];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getLCM(arr[0], arr[1])).append("\n");
        }

        System.out.println(sb);
    }

    // 최대공약수 구하는 함수
    public static int getGCD(int num1, int num2) {
        int gcd = 1;

        for(int i = 1; i <= num1 && i <= num2; i++) {
            if(num1 % i == 0 && num2 % i == 0) gcd = i;
        }

        return gcd;
    }

    // 최소공배수 구하는 함수
    public static int getLCM(int num1, int num2) {
        return (num1 * num2) / getGCD(num1, num2);
    }
}
