import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				for(int k = j + 1; k < arr.length; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					
					if(temp == m) {			// 더한 값이 m과 같을 경우
						result = temp;
						break;
					}
					
					if(temp < m && result < temp) {		// 더한 값이 m을 넘지 않으면서  temp가 더 클 경우 result에 넣어줌
						result = temp;
					}
				}
			}
		}
		
		System.out.println(result);

	}

}
