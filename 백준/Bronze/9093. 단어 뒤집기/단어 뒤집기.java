import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				StringBuilder reverseStr = new StringBuilder(str);
				sb.append(reverseStr.reverse().toString()).append(" ");	
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
