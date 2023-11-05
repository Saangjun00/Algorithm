import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);		// 1부터 N까지 큐에 값 추가
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			count++;
			if(count == K) {
				sb.append(queue.poll());
				if(!queue.isEmpty()) {
					sb.append(", ");
				}
				count =  0;
			}
			else {
				queue.add(queue.poll());
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);
	}

}
