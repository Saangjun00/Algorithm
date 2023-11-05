import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	static int N;
	static int[] arr_N;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr_N = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr_N[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr_N);

		int M = Integer.parseInt(br.readLine());
		int[] arr_M = new int[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			arr_M[i] = Integer.parseInt(st2.nextToken());
			if(binarySearch(arr_M[i])) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean binarySearch(int n) {
		int low = 0;
		int high = N - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(arr_N[mid] > n) {
				high = mid - 1;
			}
			else if(arr_N[mid] < n) {
				low = mid + 1;
			}
			else {
				return true;
			}
		}
		return false;
	}

}
