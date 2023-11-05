import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		String str = scan.next();
		
		final int M = 1234567891;
		long sum = 0;
		long pow = 1;
		
		for(int i = 0; i < num; i++) {
			sum += ((str.charAt(i) - 96) * pow);
			// pow는 31을 매번 곱해주고, 곱할 때마다 M을 나눠주면 long을 넘기지 않음
			pow = (pow * 31) % M;
		}
		
		long hash = sum % M;
		System.out.println(hash);

	}

}
