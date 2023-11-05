import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] token = str.split(" ");
			
			if(token[0].equals("push")) {
				push(Integer.parseInt(token[1]));
			}
			
			if(token[0].equals("pop")) {
				pop();
			}
			
			if(token[0].equals("size")) {
				size();
			}
			
			if(token[0].equals("empty")) {
				empty();
			}
			
			if(token[0].equals("front")) {
				front();
			}
			
			if(token[0].equals("back")) {
				back();
			}
		}
		
		System.out.println(sb);
	}
	
	public static void push(int x) {
		queue.add(x);
	}
	
	public static void pop() {
		if(queue.isEmpty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(queue.poll()).append("\n");
		}
	}
	
	public static void size() {
		sb.append(queue.size()).append("\n");
	}
	
	public static void empty() {
		if(queue.isEmpty()) {
			sb.append(1).append("\n");
		}
		else {
			sb.append(0).append("\n");
		}
	}
	
	public static void front() {
		if(queue.isEmpty()) {
			sb.append(-1).append("\n");
		}
		else {
			sb.append(queue.peek()).append("\n");
		}
	}
	
	public static void back() {
		if(queue.isEmpty()) {
			sb.append(-1).append("\n");
		}
		else {
			int pos = queue.size() - 1;
			
			while(true) {
				int element = 0;
				
				if(pos == 0) {
					sb.append(queue.peek()).append("\n");
					element = queue.remove();
					queue.add(element);
					break;
				}
				
				element = queue.remove();
				queue.add(element);	
				pos--;
			}
		}
	}

}
