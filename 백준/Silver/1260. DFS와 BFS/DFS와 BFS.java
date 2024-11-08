import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    

 public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 정점의 개수
        M = Integer.parseInt(st.nextToken());       // 간선의 개수
        V = Integer.parseInt(st.nextToken());       // 탐색을 시작할 정점 번호

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 그래프 간선 입력
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = graph[node2][node1] = 1;
        }

        // DFS 탐색
        dfs(V, sb);
        
        // BFS 탐색을 위해 다시 초기화
        visited = new boolean[N + 1];
        sb.append("\n");

        // BFS 탐색
        bfs(V, sb);
    
        System.out.println(sb);
    }

    private static void dfs(int node, StringBuilder sb) {
        visited[node]= true;
        sb.append(node).append(" ");
        
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i, sb);
            }
        }
    }

    private static void bfs(int startNode, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int i = 1; i <= N; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
