import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String[] arr = new String[4];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = st.nextToken();
        }

        // 1번째와 2번째를 문자열을 이어붙히고 long타입으로 변환, 3번째와 4번째도 이와 같이 변환하여 서로 덧셈
        long result = Long.parseLong(arr[0].concat(arr[1])) + Long.parseLong(arr[2].concat(arr[3]));

        sb.append(result);

        System.out.println(sb);
    }
}
