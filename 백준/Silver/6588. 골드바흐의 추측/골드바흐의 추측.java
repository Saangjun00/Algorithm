import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = true;

        // 소수 구하기(에라토스테네스의 체) 소수는 false
        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(!arr[i]) {
                for(int j = i*i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;

            // 종료 조건
            if(n == 0) break;

            // 두 소수의 합 찾기
            for(int i = 2; i <= n/2; i++) {
                if(!arr[i] && !arr[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n-i).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }

        System.out.println(sb);
    }
}