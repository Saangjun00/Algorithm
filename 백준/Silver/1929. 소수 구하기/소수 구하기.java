import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 소수 구하기
        for(int i = m;  i <= n; i++) {
            if(i == 1) continue;
            if(isPrimenum(i)) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    // 소수 구하기(에라토스테네스의 체)
    public static boolean isPrimenum(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
