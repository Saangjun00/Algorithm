import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 도감에 수록된 포켓몬 개수
        int M = Integer.parseInt(st.nextToken());       // 맞춰야 하는 문제의 수

        // 도감 수록
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            map1.put(i, pokemon);
            map2.put(pokemon, i);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            boolean isNumber = str.matches("^[0-9]*$");

            if (isNumber) {
                int num = Integer.parseInt(str);
                sb.append(map1.get(num)).append("\n");
            } else {
                sb.append(map2.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
