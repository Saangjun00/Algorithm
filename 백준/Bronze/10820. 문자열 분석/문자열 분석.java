import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";

        while((str = br.readLine()) != null) {
            int small = 0, large = 0, num = 0, space = 0;
            
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(ch >= 'a' && ch <= 'z') small++;
                else if(ch >= 'A' && ch <= 'Z') large++;
                else if(ch >= '0' && ch <= '9') num++;
                else if(ch == ' ') space++;
            }

            sb.append(small).append(" ").append(large).append(" ").append(num).append(" ").append(space).append("\n");
        }
        
        System.out.println(sb);
    }
}
