import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] gragh;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gragh = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                gragh[i][j] = line.charAt(j) - '0';
            }
        }

        // (0, 0)에서 bfs 탐색
        int result = bfs(0, 0);

        sb.append(result);
        System.out.println(sb);
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = true;

        // 상하좌우 이동을 위한 좌표 배열
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 현재 위치부터 도착지점까지 계산할 이동 거리 배열
        int[][] distance = new int[N][M];
        distance[startX][startY] = 1;       // 시작 위치도 카운트 포함

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            // 도착 지점에 도달하면 거리 반환
            if (currentX == N - 1 && currentY == M - 1) {
                return distance[currentX][currentY];
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int x = currentX + dx[i];
                int y = currentY + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (gragh[x][y] == 1 && !visited[x][y]) {
                        queue.offer(new int[] {x, y});
                        visited[x][y] = true;
                        distance[x][y] = distance[currentX][currentY] + 1;
                    }
                }
            }
        }

        return -1;
    }
}
