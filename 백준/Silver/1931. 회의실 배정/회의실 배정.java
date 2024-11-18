import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());        // 회의 수
        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());      // 시작 시간
            schedule[i][1] = Integer.parseInt(st.nextToken());      // 종료 시간
        }

        // 정렬 재정의
        Arrays.sort(schedule, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같으면 시작 시간을 기준으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                // 종료 시간을 기준으로 정렬
                else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 0;
        int prevEndTime = 0;        // 이전 회의 종료 시간

        for (int i = 0; i < N; i++) {
            if (prevEndTime <= schedule[i][0]) {
                count++;
                prevEndTime = schedule[i][1];
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
}
