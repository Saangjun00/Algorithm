import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String str = scan.next();
			boolean flag = false;
			
			if(str.equals("0")) {
				break;
			}
				
			for(int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
				if(str.charAt(i) != str.charAt(j)) {
					flag = false;
					break;
				}
				else {
					flag = true;
				}
			}
			
			if(str.length() == 1) {
				flag = true;
			}
			
			if(flag) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
			
		}

	}

}
