import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                ch += 13;

                // 아스키코드 'z' 넘어갈시 처리
                if(ch > 'z') {
                    ch -= 26;
                }
            }
            else if(ch >= 'A' && ch <= 'Z') {
                ch += 13;

                // 아스키코드 'Z' 넘어갈시 처리
                if(ch > 'Z') {
                    ch -= 26;
                }
            }

            sb.append(ch);
        }

        System.out.println(sb);
    }
}
