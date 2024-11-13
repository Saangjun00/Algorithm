import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 세로
        int M = Integer.parseInt(st.nextToken());       // 가로
        int B = Integer.parseInt(st.nextToken());       // 초기 블록 수

        int[][] ground = new int[N][M];
        int min = Integer.MAX_VALUE;                    // 가장 낮은 층
        int max = Integer.MIN_VALUE;                    // 가장 높은 층
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, ground[i][j]);
                max = Math.max(max, ground[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = -1;

        // 높은 층부터 낮은 층으로 브루트포스 탐색
        for (int i = max; i >= min; i--) {
            int currentTime = 0;        // 현재 높이로 만드는데 걸리는 시간
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = ground[j][k] - i;

                    // 현재 위치가 목표 층보다 높으면 블록 제거 (2초)
                    if (diff > 0) {
                        currentTime += (diff * 2);
                        block += diff;
                    }

                    // 현재 위치가 목표 층보다 낮으면 블록 추가 (1초)
                    else {
                        currentTime -= diff;
                        block += diff;
                    }
                }
            }

            // 블록 수가 부족하면 해당 층 탐색을 건너 뜀
            if (block < 0) continue;

            if (minTime > currentTime) {
                minTime = currentTime;
                height = i;
            }
        }

        sb.append(minTime).append(" ").append(height);
        System.out.println(sb);
    }
}
