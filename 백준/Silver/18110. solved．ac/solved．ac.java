import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        int[] level = new int[n];
        for(int i = 0; i < level.length; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        double a = Math.round(n * 0.15);

        for(int i = (int)a; i < level.length - a; i++) {
            sum += level[i];
        }

        double result = sum / (n - 2 * a);

        sb.append(Math.round(result));

        System.out.println(sb);
    }
}
