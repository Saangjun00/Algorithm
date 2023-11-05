import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger fact = new BigInteger("1");
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		
		String str = String.valueOf(fact);
		
		for(int i = str.length() - 1; i > 0; i--) {
			if(str.charAt(i) == '0') {
				count++;
			}
			else {
				break;
			}
		}
		
		System.out.println(count);

	}

}
