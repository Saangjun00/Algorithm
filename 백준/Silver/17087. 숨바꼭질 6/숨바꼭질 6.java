import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 동생들과의 거리 구하기
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i] - S); 
        }

        // 모든 거리들간의 최대공약수 구하기
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = getGCD(result, arr[i]);
        }

        sb.append(result).append("\n");

        System.out.println(sb);
    }

    // 최대공약수 구하기(유클리드 호제법)
    private static int getGCD(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}
