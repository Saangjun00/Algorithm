import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int[] arr = new int[num];
		int prime_num = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			prime_num += is_prime(arr[i]);
		}
		
		System.out.println(prime_num);

	}
	
	private static int is_prime(int num) {
		if(num == 1) {
			return 0;
		}
		if(num == 2) {
			return 1;
		}
		
		boolean is_prime = true;
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				is_prime = false;
				break;
			}
		}
		
		if(is_prime) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
