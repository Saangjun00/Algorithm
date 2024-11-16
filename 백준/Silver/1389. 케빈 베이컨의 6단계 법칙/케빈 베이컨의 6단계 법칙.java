import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 유저의 수
        M = Integer.parseInt(st.nextToken());       // 관계의 수

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        int result = 0;
        int min = Integer.MAX_VALUE;        // 케빈 베이컨의 수가 가장 작은 사람

        for (int i = 1; i <= N; i++) {
            int KevinBacon = bfs(i);        // 각 유저마다 케빈 베이컨의 수

            if (KevinBacon < min) {
                min = KevinBacon;
                result = i;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    distance[i] = distance[node] + 1;
                }
            }
        }

        int totalDistance = 0;
        for (int len : distance) {
            totalDistance += len;
        }

        return totalDistance;
    }
}
