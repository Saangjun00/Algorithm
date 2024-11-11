import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 나무의 수
        int M = Integer.parseInt(st.nextToken());       // 가져가려는 나무의 길이

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            // max값 찾기
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        // binary search
        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int height : tree) {
                if (height - mid > 0) {
                    sum += height - mid;
                }
            }

            if (sum < M) {
                max = mid - 1;
            }

            else {
                min = mid + 1;
            }
        }

        sb.append(max);

        System.out.println(sb);
    }
}
