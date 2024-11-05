import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[][] graph;
    static int count = 0;

    static int node;        // 컴퓨터의 수
    static int line;        // 간선의 수

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        graph = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int computer1 = Integer.parseInt(st.nextToken());
            int computer2 = Integer.parseInt(st.nextToken());

            graph[computer1][computer2] = graph[computer2][computer1] = 1;
        }

        dfs(1);

        sb.append(count - 1);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        count++;

        for (int i = 0; i <= node; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
