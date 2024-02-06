import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[m];
        for(int i = arr.length - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // A진수 -> 10진수
        int decimal = 0;
        for(int i = 0; i < arr.length; i++) {
            decimal += arr[i] * Math.pow(A, i);
        }

        // 예외처리
        if(decimal == 0) {
            System.out.println(0);
            return;
        }

        // 10진수 -> B진수
        while(decimal > 0) {
            int result = decimal % B;
            sb.insert(0, result + " ");
            decimal /= B;
        }

        System.out.println(sb);
    }
}
