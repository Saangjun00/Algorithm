import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			if(++count == K) {
				sb.append(queue.poll());
				if(!queue.isEmpty()) {
					sb.append(", ");
				}
				count = 0;
			}
			else {
				queue.add(queue.poll());
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);
		
	}

}
