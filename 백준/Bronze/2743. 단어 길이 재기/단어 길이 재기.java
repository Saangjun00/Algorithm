import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int count = 0;;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')) {
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
}
