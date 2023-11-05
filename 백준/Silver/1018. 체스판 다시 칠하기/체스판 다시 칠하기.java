import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[][] board;
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == 'W') {
					board[i][j] = true;
				}
				else {
					board[i][j] = false;
				}
			}
		}
		
		// 최소 크기가 8x8일 경우
		int N_row = N - 7;
		int M_col = M - 7;
		
		for(int i = 0; i < N_row; i++) {
			for(int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		
		System.out.println(min);
	}

	
	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		
		boolean TF = board[x][y];	// 첫번째 칸의 색
		
		for(int i = x; i < end_x; i++) {
			for(int j = y; j < end_y; j++) {
				// 올바른 색이 아닐 경우 count 1 증가
				if(board[i][j] != TF) {
					count++;
				}
				
				TF = !TF;		// 색이 바뀌므로
			}
			
			TF = !TF;
		}
		
		count = Math.min(count, 64 - count);		// 색칠할 최소한의 개수를 count에 저장
		
		min = Math.min(min, count);					// 최솟값 갱신
	}
}
