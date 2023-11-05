import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		String str = "666";
		
		for(int i = 0; ; i++) {
			if(String.valueOf(i).contains(str)) {
				count++;
			}
			
			if(count == N) {
				System.out.println(i);
				break;
			}
		}
	}

}
