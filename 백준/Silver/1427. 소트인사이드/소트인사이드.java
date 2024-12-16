import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] digit = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digit[i] = str.substring(i, i + 1);
        }

        Arrays.sort(digit, Collections.reverseOrder());

        for (String s : digit) {
            System.out.print(s);
        }
    }
}
