import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int cnt = 1;
		int sum = 1;
		
		for(int i = 1; sum < num; i++) {
			sum += i * 6;
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
