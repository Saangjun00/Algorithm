import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int N;
    private static int[][] apt;
    private static boolean[][] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        apt = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                apt[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> danji = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apt[i][j] == 1 && !visited[i][j]) {
                    count = 0;      // 단지 내 집의 수 초기화
                    dfs(i, j);
                    danji.add(count);
                }
            }
        }

        Collections.sort(danji);    // 오름차순 정렬

        // 단지 수 출력
        sb.append(danji.size()).append("\n");

        // 단지 내 집의 수 출력
        for (int size : danji) {
            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        // 상하좌우 탐색할 좌표 배열
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (apt[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
