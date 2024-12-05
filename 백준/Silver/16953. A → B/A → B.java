import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static long A, B;

    public static void main(String[] args) throws IOException {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        long result = bfs(A);

        sb.append(result);
        System.out.println(sb);
    }

    private static long bfs(long start) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {start, 1});     // {현재 값, 연산 횟수}

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long value = current[0];    // 현재 값
            long count = current[1];    // 연산 횟수

            // B에 도달한 경우 count값 반환
            if (value == B) {
                return count;
            }

            // B를 초과한 경우 연산 무시
            if (value > B) {
                continue;
            }

            long A1 = value * 2;                        // 2를 곱하는 경우
            long A2 = Long.parseLong(value + "1");      // 1을 수의 가장 오른쪽에 추가하는 경우

            queue.offer(new long[] {A1, count + 1});
            queue.offer(new long[] {A2, count + 1});
        }

        return -1;
    }
}
