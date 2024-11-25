import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());        // 테스트 케이스 수

        while (T-- > 0) {
            String func = br.readLine();                // 수행할 함수
            int n = Integer.parseInt(br.readLine());    // 배열의 길이
            String arr = br.readLine();                 // 배열 입력

            // 배열 숫자 구분
            arr = arr.replace("[", "").replace("]", "").replace(",", " ");
            StringTokenizer st = new StringTokenizer(arr);

            // 덱 생성
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (st.hasMoreTokens()) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            // 함수 수행할 변수
            boolean isReverse = false;
            boolean isError = false;

            for (int i = 0; i < func.length(); i++) {
                char AC = func.charAt(i);

                if (AC == 'R') {
                    isReverse = !isReverse;
                }

                else if (AC == 'D') {
                    // 덱이 비어있으면 에러 발생
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    // 뒤집어진 경우
                    if (isReverse) {
                        deque.removeLast();
                    }

                    else {
                        deque.removeFirst();
                    }
                }
            }

            // 덱이 비어 있는 상태에서 'D'함수 수행시 에러 발생
            if (isError) {
                sb.append("error\n");
            }

            else {
                sb.append("[");

                while (!deque.isEmpty()) {
                    if (isReverse) {
                        sb.append(deque.removeLast());
                    }

                    else {
                        sb.append(deque.removeFirst());
                    }

                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }

                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }
}
