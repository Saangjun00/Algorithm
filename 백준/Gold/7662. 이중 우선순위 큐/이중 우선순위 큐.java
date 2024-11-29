import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)  throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());        // 테스트 케이스 수

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());        // 연산의 개수

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> countMap = new HashMap<>();
 
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                // 삽입 연산
                if (operation == 'I') {
                    minHeap.offer(num);
                    maxHeap.offer(num);
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);   // 숫자와 빈도수를 저장
                }

                // 삭제 연산
                else {
                    // 최대값 삭제
                    if (num == 1) {
                        // 빈도수가 0이면 제거
                        while (!maxHeap.isEmpty() && countMap.get(maxHeap.peek()) == 0) {
                            maxHeap.poll();
                        }

                        if (!maxHeap.isEmpty()) {
                            int max = maxHeap.poll();
                            countMap.put(max, countMap.get(max) - 1);
                        }
                    }

                    // 최소값 삭제
                    else {
                        // 빈도수가 0이면 제거
                        while (!minHeap.isEmpty() && countMap.get(minHeap.peek()) == 0) {
                            minHeap.poll();
                        }

                        if (!minHeap.isEmpty()) {
                            int min = minHeap.poll();
                            countMap.put(min, countMap.get(min) - 1);
                        }
                    }
                }
            }

            // 빈도수 0이 남아있을 가능성이 있기 때문에 한번 더 수행
            while (!maxHeap.isEmpty() && countMap.get(maxHeap.peek()) == 0) {
                maxHeap.poll();
            }

            while (!minHeap.isEmpty() && countMap.get(minHeap.peek()) == 0) {
                minHeap.poll();
            }

            if (minHeap.isEmpty() || maxHeap.isEmpty()) {
                sb.append("EMPTY\n");
            }
            
            else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
