import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 한 변의 길이

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    private static void divide(int x, int y, int size) {
        int sum = 0;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += paper[i][j];
            }
        }

        // 나눠진 정사각형이 모두 하얀색인 경우
        if (sum == 0) {
            white++;
        }

        // 나눠진 정사각형이 모두 파란색인 경우
        else if (sum == size * size) {
            blue++;
        }

        // 다시 분할
        else {
            int halfSize = size / 2;

            divide(x, y, halfSize);                            // 2사분면
            divide(x, y + halfSize, halfSize);                 // 1사분면
            divide(x + halfSize, y, halfSize);                 // 3사분면
            divide(x + halfSize, y + halfSize, halfSize);      // 4사분면
        }
    }
}
