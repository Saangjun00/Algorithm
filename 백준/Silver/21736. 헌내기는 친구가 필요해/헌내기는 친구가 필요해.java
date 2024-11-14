import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static char[][] campus;
    private static boolean[][] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];
        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);

                // 도연이의 위치
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        // 사람을 한번도 안 만난 경우
        if (count == 0) {
            sb.append("TT");
        }

        else {
            sb.append(count);
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 범위 체크, 방문 여부, 벽 여부 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && campus[nx][ny] != 'X') {
                    visited[nx][ny] = true;

                    // 사람을 만난 경우
                    if (campus[nx][ny] == 'P') {
                        count++;
                    }

                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
