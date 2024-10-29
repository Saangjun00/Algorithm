import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // TestCase

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   // 문서의 개수
            int M = Integer.parseInt(st.nextToken());   // 몇번째로 인쇄되는지 나타내는 문서의 순서 번호

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while(!queue.isEmpty()) {
                int[] first = queue.poll();     // 첫 번째 원소
                boolean isMax = true;           // 해당 원소가 가장 큰 원소인지 비교하는 변수

                for(int i = 0; i < queue.size(); i++) {

                    if(first[1] < queue.get(i)[1]) {
                        queue.offer(first);

                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) {
                    continue;
                }

                count++;
                
                if(first[0] == M) {
                    break;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
