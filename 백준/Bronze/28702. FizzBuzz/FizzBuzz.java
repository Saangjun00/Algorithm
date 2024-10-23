import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = 0;

        // 숫자인지 여부를 체크하는 변수
        boolean flag = false;

        for(int i = 0; i < 3; i++) {
            String str = br.readLine();

            char c = str.charAt(0);

            if(c != 'F' && c != 'B') {
                num = Integer.parseInt(str);
                flag = true;
            }

            if(flag) {
                num++;
            }
        }
    
        if(num % 3 == 0) {
            if(num % 5 == 0) {
                sb.append("FizzBuzz\n");
            } else {
            sb.append("Fizz\n");
            }
        } else {
            if(num % 5 == 0) {
                sb.append("Buzz\n");
            } else {
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }
}
