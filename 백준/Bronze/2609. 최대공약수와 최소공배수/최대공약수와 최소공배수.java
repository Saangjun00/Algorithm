import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		int gcd = getGCD(num1, num2);
		int lcm = getLCM(num1, num2);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	public static int getGCD(int num1, int num2) {
		int gcd = 1;
		
		for(int i = 1; i <= num1 && i <= num2; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		
		return gcd;
	}
	
	public static int getLCM(int num1, int num2) {
		return (num1 * num2) / getGCD(num1,num2);
	}

}

