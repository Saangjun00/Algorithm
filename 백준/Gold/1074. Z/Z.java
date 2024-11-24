import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);

        divideConquer(size, row, col);

        sb.append(count);
        System.out.println(sb);
    }

    private static void divideConquer(int size, int row, int col) {
        int halfSize = size / 2;

        if (size == 1) {
            return;
        }

        // 2사분면
        if (row < halfSize && col < halfSize) {
            divideConquer(halfSize, row, col);
        }

        // 1사분면
        else if (row < halfSize && col >= halfSize) {
            count += size * size / 4;
            divideConquer(halfSize, row, col - halfSize);
        }

        // 3사분면
        else if (row >= halfSize && col < halfSize) {
            count += (size * size / 4) * 2;
            divideConquer(halfSize, row - halfSize, col);
        }

        // 4사분면
        else if (row >= halfSize && col >= halfSize) {
            count += (size * size / 4) * 3;
            divideConquer(halfSize, row - halfSize, col - halfSize);
        }
    }
}
