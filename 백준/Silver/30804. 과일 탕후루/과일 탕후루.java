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

        int N = Integer.parseInt(br.readLine());        // 과일의 개수
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        // Map을 사용하여 과일의 종류와 개수 저장
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        // 투 포인터
        for (int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 과일의 종류가 2종류를 넘어가면 2종류가 될 때까지 map에서 제거
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // 최대값 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }

        sb.append(maxLength);
        System.out.println(sb);
    }
}
