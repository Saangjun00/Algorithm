import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			if(N % 5 == 0) {
				count++;
				N -= 5;
				
				if(N == 0) {
					break;
				}
				continue;
			}
			
			else if(N % 3 == 0) {
				count++;
				N -= 3;
				
				if(N == 0) {
					break;
				}
				continue;
			}
			
			if(N == 0) {
				break;
			}
			
			if(N < 0) {
				count = -1;
				break;
			}
			
			count++;
			N -= 3;
		}
		
		sb.append(count);
		
		System.out.println(sb);

	}

}
