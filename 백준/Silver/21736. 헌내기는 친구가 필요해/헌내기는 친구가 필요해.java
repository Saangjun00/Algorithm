import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        dfs(startX, startY);

        // 사람을 한번도 안 만난 경우
        if (count == 0) {
            sb.append("TT");
        }

        else {
            sb.append(count);
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        // 범위 밖이거나 벽이거나 방문한 경우
        if (x < 0 || x >= N || y < 0 || y >= M || campus[x][y] == 'X' || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        // 사람을 만난 경우
        if (campus[x][y] == 'P') {
            count++;
        }

        // 상하좌우 이동
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
        }
    }
}
