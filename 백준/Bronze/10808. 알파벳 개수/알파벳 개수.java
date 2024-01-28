import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String data = br.readLine();
        int[] alp = new int[26];    // 알파벳 개수를 넣을 배열

        for(int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                alp[ch - 'a']++;
            }
        }

        for(int i = 0; i < alp.length; i++) {
            sb.append(alp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
