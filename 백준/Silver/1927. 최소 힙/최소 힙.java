import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                }

                else {
                    sb.append(minHeap.poll()).append("\n");
                }
            }

            else {
                minHeap.offer(x);
            }
        }

        System.out.println(sb);
    }
}
