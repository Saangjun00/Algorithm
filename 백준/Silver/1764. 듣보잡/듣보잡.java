import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());       // 보도 못한 사람으 수

        Set<String> set = new HashSet<>();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            
            // 중복되면 리스트에 추가
            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (String str : list) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
