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

            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 모든 쌍의 최대공약수 구한 합계
            long result = 0;
            for(int i = 0; i < arr.length - 1; i++) {
                for(int j = i + 1; j < arr.length; j++) {
                    result += getGCD(arr[i], arr[j]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    // 최대공약수 구하는 함수(유클리드 호제법)
    private static int getGCD(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}
