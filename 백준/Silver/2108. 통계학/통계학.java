import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        double sum = 0;

        int[] num = new int[N];
        for(int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }
        
        Arrays.sort(num);

        // 입력값 범위: -4000 ~ 4000
        int[] count = new int[8001];
        for(int i = 0; i < num.length; i++) {
            count[4000 + num[i]]++;     // 인덱스 4000 = 0
        }

        int mode = 0;
        int mode_max = 0;
        boolean flag = false;      // 최빈값이 한번 true, 여러번일 경우 false
        for(int i = 0; i < count.length; i++) {
            if(mode_max < count[i]) {
                mode_max = count[i];
                mode = i - 4000;
                flag = true;
            }

            // 최빈값이 여러 개 있을 경우 두 번째로 등장하는 값
            else if(mode_max == count[i] && flag == true) {
                mode = i - 4000;
                flag = false;
            }
        }

        sb.append(Math.round(sum / N)).append("\n");
        sb.append(num[N / 2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(num[N - 1] - num[0]);

        System.out.println(sb);
    }
}
