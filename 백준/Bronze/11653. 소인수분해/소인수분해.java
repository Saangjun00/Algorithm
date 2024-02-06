import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[10000001];
        arr[0] = arr[1] = true;

        // 소수 구하기(에라토스테네스의 체)
        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            for(int j = i*i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());

        // 소인수분해
        while (N != 1) {
            for(int i = 0; i < arr.length; i++) {
                if(!arr[i]) {
                    if(N % i == 0) {
                        sb.append(i).append("\n");
                        N /= i;
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
