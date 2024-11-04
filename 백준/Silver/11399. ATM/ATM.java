import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int prev = 0;       // 이전까지 대기시간 누적합
        int sum = 0;        // 대기시간 총합

        for (int i = 0; i < arr.length; i++) {
            sum += prev + arr[i];
            prev += arr[i];
        }

        sb.append(sum);

        System.out.println(sb);
    }
}
