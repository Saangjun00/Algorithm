import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr, result;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);

        System.out.println(sb);
    }

    private static void dfs(int index, int depth) {

        if (depth == M) {
            for (int temp : result) {
                sb.append(temp).append(" ");
            }

            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = index; i < N; i++) {
            if (before != arr[i]) {
                before = arr[i];
                result[depth] = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}
