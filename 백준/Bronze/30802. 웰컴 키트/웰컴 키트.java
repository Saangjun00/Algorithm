import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < size.length; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i < size.length; i++) {
            cnt += size[i] / T;
            cnt = size[i] % T > 0 ? cnt + 1 : cnt;
        }

        sb.append(cnt).append("\n");
        sb.append(N / P).append(" ").append(N % P);
        
        System.out.println(sb);
    }
}
