import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] distance = new int[N - 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            distance[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(distance);

        int gcd = findGcd(distance);

        int addTree = 0;
        for (int i = 0; i < N - 1; i++) {
            addTree += (distance[i] / gcd) - 1;
        }

        System.out.println(addTree);
    }

    private static int gcd(int a, int b) {
        
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    private static int findGcd(int[] arr) {

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }

        if (result == 1) return 1;

        return result;
    }
}
