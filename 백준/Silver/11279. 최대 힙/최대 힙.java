import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 연산 횟수

        // MaxHeap 초기화
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());    // 입력 값

            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append(0).append("\n");
                }

                else {
                    sb.append(maxHeap.poll()).append("\n");
                }
            }

            else {
                maxHeap.offer(x);
            }
        }

        System.out.println(sb);
    }
}
