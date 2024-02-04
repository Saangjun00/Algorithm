import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        // 8진수 -> 10진수
        BigInteger result = new BigInteger(str, 8);

        // 10진수 -> 2진수
        sb.append(result.toString(2));

        System.out.println(sb);
    }
}
