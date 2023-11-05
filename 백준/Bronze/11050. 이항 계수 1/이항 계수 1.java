import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int result = fact(N) / (fact(N - K) * fact(K));
		
		System.out.println(result);

	}
	
	public static int fact(int n) {
		int result = 1;
		
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}

}
