import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());       // 이미 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());       // 필요한 랜선의 개수

        long max = 0;

        int[] arr = new int[K];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        long min = 1;
        long result = 0;

        // binary search
        while (min <= max) {
            
            long mid = (min + max) / 2;

            long count = 0;

            for(int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {
                max = mid - 1;
            }

            else {
                result = mid;
                min = mid + 1;
            }
        }

        sb.append(result);

        System.out.println(sb);
    }
}
