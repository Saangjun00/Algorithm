import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = true;

        // 소수 구하기(에라토스테네스의 체)
        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(!arr[i]) {
                for(int  j = i*i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            
            // 두 소수의 합 찾기
            for(int i = 2; i <= N/2; i++) {
                if(!arr[i] && !arr[N - i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
