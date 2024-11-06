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

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cloth = st.nextToken();      // 의상 이름
                String type = st.nextToken();       // 의상 종류

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int val : map.values()) {
                result *= (val + 1);        // 안 입는 경우: +1
            }

            sb.append(result - 1).append("\n");     // 알몸이 아닌 상태 제외
        }

        System.out.println(sb);
    }
}
