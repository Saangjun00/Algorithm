import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 0; i < t; i++) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			
			int floor;
			int roomNum;
			
			if(n % h == 0) {
				floor = h;
				roomNum = n / h;
			}
			else {
				floor = n % h;
				roomNum = n / h + 1;
			}
			
			int result = 100*floor + roomNum;
			
			System.out.println(result);
		}
	}
}
