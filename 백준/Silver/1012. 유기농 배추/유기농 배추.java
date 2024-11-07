import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] field;       // 배추밭
    static boolean[][] check;   // 배추가 있는지 체크

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());        // 테스트 케이스

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken());       // 배추밭의 세로 길이
            field = new int[M][N];
            check = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());   // 배추가 심어져 있는 위치의 개수

            // 배추가 심어진 위치를 1로 표시
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !check[i][j]) {
                        bfs(i, j);      // bfs를 통해 연결된 배추들을 모두 방문 처리
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {startX, startY});
        check[startX][startY] = true;

        // 상하좌우 방향으로 인접한 배추를 탐색하기 위한 좌표 배열
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            // 4방향으로 인접한 배추 탐색
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + dx[i];
                int y = poll[1] + dy[i];

                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (field[x][y] == 1 && !check[x][y]) {
                        queue.offer(new int[] {x, y});
                        check[x][y] = true;
                    }
                }
            }
        }
    }
}