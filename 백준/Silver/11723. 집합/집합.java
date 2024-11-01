import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();

        int M = Integer.parseInt(br.readLine());    // 연산의 횟수

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
            
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                
                case "check":
                    boolean result = set.contains(Integer.parseInt(st.nextToken()));
                    sb.append(result ? 1: 0).append("\n");
                    break;

                case "toggle":
                    int num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }

                    break;

                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }

                    break;

                case "empty":
                    set.clear();
                    break;
            }
        }
        
        System.out.println(sb);
    }
}
