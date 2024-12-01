import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited;
    private static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 가로 길이
        M = Integer.parseInt(st.nextToken());       // 세로 길이

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;      // 상태 초기화
                makeT(i, j);                // T 조합
            }
        }

        sb.append(maxSum);
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int sum, int depth) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 4개의 도형이 이어지면 최댓값을 비교
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + board[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    private static void makeT(int x, int y) {
        // T 도형을 만들 수 있는 좌표
        int[][][] Tshape = {
            {{0, -1}, {-1, 0}, {0, 1}},  // 위쪽 ㅗ
            {{0, -1}, {0, 1}, {1, 0}},  // 아래쪽 ㅜ
            {{0, -1}, {-1, 0}, {1, 0}},    // 왼쪽 ㅓ
            {{-1, 0}, {1, 0}, {0, 1}}     // 오른쪽 ㅏ
        };

        for (int[][] shape : Tshape) {
            int sum = board[x][y];
            boolean valid = true;

            for (int[] cord : shape) {
                int nx = x + cord[1];
                int ny = y + cord[0];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    valid = false;
                    break;
                }

                sum += board[nx][ny];
            }

            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}
