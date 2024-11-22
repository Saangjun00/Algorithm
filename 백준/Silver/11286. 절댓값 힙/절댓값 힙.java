import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 연산 횟수

        // 절댓값 우선 정렬 재정의
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            int abs_o1 = Math.abs(o1);
            int abs_o2 = Math.abs(o2);

            if (abs_o1 == abs_o2) {
                return o1 - o2;
            }

            return abs_o1 - abs_o2;
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append("\n");
                }

                else {
                    sb.append(heap.poll()).append("\n");
                }
            }

            else {
                heap.offer(x);
            }
        }

        System.out.println(sb);
    }
}
