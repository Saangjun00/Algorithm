import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws 
    IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String[] arr = new String[str.length()];

        // 모든 접미사를 배열에 넣어주기
        for(int i = 0; i < arr.length; i++) {
                arr[i] = str.substring(i, arr.length);
        }

        // 사전순으로 정렬
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
