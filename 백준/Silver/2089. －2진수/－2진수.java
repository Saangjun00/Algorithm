import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if(N == 0) System.out.println(0);

        else{
            while(N != 1) {
                // -2진수 구하는 방법
                sb.append(Math.abs(N % -2));
                N = (int)Math.ceil((double)N / -2);
            }

            sb.append(N);
        }
        
        System.out.println(sb.reverse());
    }
}
