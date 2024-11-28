import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] board;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 사다리 수
        int M = Integer.parseInt(st.nextToken());       // 뱀의 수

        board = new int[101];
        visited = new boolean[101];

        for (int i = 1; i < board.length; i++) {
            board[i] = i;
        }

        // 사다리 이동(x번 칸 -> y번 칸)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        // 뱀 이동(u번 칸 -> v번 칸)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        int result = bfs(1);

        sb.append(result);
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});  // 현재 위치와 이동횟수 저장
        visited[start] = true;

        while (!queue.isEmpty()) { 
            int[] poll = queue.poll();
            int pos = poll[0];
            int move = poll[1];

            if (pos == 100) {
                return move;
            }

            for (int i = 1; i <= 6; i++) {
                int nextPos = pos + i;

                if (nextPos > 100) continue;    // 게임판을 넘어가면 무시

                nextPos = board[nextPos];

                if (!visited[nextPos]) {
                    queue.offer(new int[] {nextPos, move + 1});
                    visited[nextPos] = true;
                }
            }
        }

        return -1;
    }
}
