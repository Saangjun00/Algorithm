import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] answer = new ArrayList[11];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new ArrayList<>();
        }

        // 1을 나타내는 식의 사전식 정렬
        answer[1].add("1");

        // 2를 나타내는 식의 사전식 정렬
        answer[2].add("1+1");
        answer[2].add("2");

        // 3을 나타내는 식의 사전식 정렬
        answer[3].add("1+1+1");
        answer[3].add("1+2");
        answer[3].add("2+1");
        answer[3].add("3");

        // dp[i] = dp[i - 1] + dp[i -2] + dp[i - 3]의 점화식
        for(int i = 4; i < answer.length; i++) {
            for(int j = 1; j <= 3; j++) {
                for(String s : answer[i - j]) {
                    answer[i].add(j + "+" + s);
                }
            }
        }

        if(answer[n].size() >= k) {
            sb.append(answer[n].get(k - 1));
        }

        else {
            sb.append(-1);
        }

        System.out.println(sb);
    }
}
