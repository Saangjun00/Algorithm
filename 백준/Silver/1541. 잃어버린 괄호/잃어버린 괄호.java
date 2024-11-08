import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String[] numbers = str.split("[-+]");

        // 첫 번째 숫자를 초기값으로 설정
        int result = Integer.parseInt(numbers[0]);
        int numberIndex = 1;

        boolean isFrontMinus = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-') {
                int num = Integer.parseInt(numbers[numberIndex++]);

                // -연산자가 처음 등장하면 모두 빼기 연산
                if (ch == '-') {
                    isFrontMinus = true;
                }

                if (isFrontMinus) {
                    result -= num;
                }

                else {
                    result += num;
                }
            }
        }

        sb.append(result);

        System.out.println(sb);
    }
}
