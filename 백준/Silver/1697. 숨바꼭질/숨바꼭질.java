import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] map;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];

        int result = bfs(N);

        sb.append(result);
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 위치에 도달한 경우
            if (current == K) {
                return map[current];
            }

            // 다음 이동 가능한 위치
            int[] nextPosition = {current - 1, current + 1, current * 2};

            for (int next : nextPosition) {
                if (next >= 0 && next < 100001 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    map[next] = map[current] + 1;
                }
            }
        }

        return -1;
    }
}
