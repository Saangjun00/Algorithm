import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] field;       // 배추밭
    static boolean[][] check;   // 베추가 있는지 체크
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken());       // 배추밭의 세로 길이
            field = new int[M][N];
            check = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());       // 배추가 심어져 있는 위치 개수

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
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int startX, int startY) {
        check[startX][startY] = true;

        // 배추가 상하좌우에 인접하면 이동 가능
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x >= 0 && y >= 0 && x < M && y < N) {
                if (field[x][y] == 1 && !check[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
