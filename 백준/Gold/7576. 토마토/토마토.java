import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int M, N;
    private static int[][] tomato;
    private static boolean[][] visited;
    private static int[][] distance;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;

                if (tomato[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }

                maxDay = Math.max(maxDay, distance[i][j]);
            }
        }

        sb.append(maxDay);
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                    distance[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx >= 0 && ny >=0 && nx < N && ny < M) {
                    if (tomato[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        tomato[nx][ny] = 1;
                        distance[nx][ny] = distance[currentX][currentY] + 1;
                    }
                }
            }
        }
    }
}
