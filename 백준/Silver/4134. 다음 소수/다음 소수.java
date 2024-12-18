import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());
            
            if (n <= 2) {
                System.out.println(2);
                continue;
            }

            while (true) {
                boolean flag = true;

                for (long i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(n);
                    break;
                }

                n++;
            }
        }
    }
}
