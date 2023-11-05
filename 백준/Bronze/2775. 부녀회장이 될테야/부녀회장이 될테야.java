import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[][] apt = new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 2; j < 15; j++) {
				apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
			}
		}
		
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = scan.nextInt();
			int n = scan.nextInt();
			int result = apt[k][n];
			
			System.out.println(result);
		}

	}

}
