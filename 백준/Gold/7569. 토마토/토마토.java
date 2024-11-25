import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int M, N, H;
    private static int[][][] tomato;
    private static boolean[][][] visited;
    private static int[][][] distance;
    private static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        distance= new int[H][N][M];
    
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    distance[i][j][k] = -1;

                    if (tomato[i][j][k] == 1) {
                        queue.offer(new int[] {i, j, k});
                        visited[i][j][k] = true;
                        distance[i][j][k] = 0;
                    }

                    else if (tomato[i][j][k] == -1) {
                    visited[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

        int maxDay = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0 && !visited[i][j][k]) {
                        System.out.println(-1);
                        return;
                    }

                    maxDay = Math.max(maxDay, distance[i][j][k]);
                }
            }
        }

        sb.append(maxDay);
        System.out.println(sb);
    }

    private static void bfs() {
        int[] dz = {-1, 0, 0, 1, 0, 0};
        int[] dx = {0, -1, 0, 0, 1, 0};
        int[] dy = {0, 0, -1, 0, 0, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentZ = poll[0];
            int currentX = poll[1];
            int currentY = poll[2];

            for (int i = 0; i < 6; i++) {
                int nz = currentZ + dz[i];
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M) {
                    if (tomato[nz][nx][ny] == 0 && !visited[nz][nx][ny]) {
                        queue.offer(new int[] {nz, nx, ny});
                        visited[nz][nx][ny] = true;
                        tomato[nz][nx][ny] = 1;
                        distance[nz][nx][ny] = distance[currentZ][currentX][currentY] + 1;
                    }
                }
            }
        }
    }
}
