import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		double[] score = new double[n];
		double max = score[0];
		
		for(int i = 0; i < n; i++) {
			score[i] = scan.nextDouble();
			
			if(max < score[i]) {
				max = score[i];
			}
		}
		
		double sum = 0;
		double average = 0;
		
		for(int i = 0; i < n; i++) {
			sum += score[i] / max * 100;
			average = sum / n;
		}
		
		System.out.println(average);

	}

}
