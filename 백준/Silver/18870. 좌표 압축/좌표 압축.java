import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 중복 제거 후 정렬
        int[] sortedUnuiqueArr = Arrays.stream(arr).distinct().sorted().toArray();

        // 좌표 압축 맵 생성
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedUnuiqueArr.length; i++) {
            map.put(sortedUnuiqueArr[i], i);
        }

        for (int coord : arr) {
            sb.append(map.get(coord)).append(" ");
        }

        System.out.println(sb);
    }
}
