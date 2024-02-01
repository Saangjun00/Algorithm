import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append((arr[0] + arr[1]) % arr[2]).append("\n");
        sb.append(((arr[0] % arr[2]) + (arr[1] % arr[2])) % arr[2]).append("\n");
        sb.append((arr[0] * arr[1]) % arr[2]).append("\n");
        sb.append(((arr[0] % arr[2]) * (arr[1] % arr[2])) % arr[2]).append("\n");

        System.out.println(sb);
    }
}
