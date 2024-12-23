import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String siteAddress = st.nextToken();
            String password = st.nextToken();

            map.put(siteAddress, password);
        }

        for (int i = 0; i < M; i++) {
            String siteAddress = br.readLine();

            if(map.containsKey(siteAddress)) {
                sb.append(map.get(siteAddress)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
