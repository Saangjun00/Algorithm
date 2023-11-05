import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static Deque<Integer> deque = new LinkedList<>();
	public static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] token = str.split(" ");
			
			if(token[0].equals("push_front")) {
				pushFront(Integer.parseInt(token[1]));
			}
			
			if(token[0].equals("push_back")) {
				pushBack(Integer.parseInt(token[1]));
			}
			
			if(token[0].equals("pop_front")) {
				popFront();
			}
			
			if(token[0].equals("pop_back")) {
				popBack();
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
	
	public static void pushFront(int x) {
		deque.addFirst(x);
	}
	
	public static void pushBack(int x) {
		deque.addLast(x);
	}
	
	public static void popFront() {
		if(!deque.isEmpty()) {
			sb.append(deque.pollFirst()).append("\n");
		}
		else {
			sb.append(-1).append("\n");
		}
	}
	
	public static void popBack() {
		if(!deque.isEmpty()) {
			sb.append(deque.pollLast()).append("\n");
		}
		else {
			sb.append(-1).append("\n");
		}
	}
	
	public static void size() {
		sb.append(deque.size()).append("\n");
	}
	
	public static void empty() {
		if(deque.isEmpty()) {
			sb.append(1).append("\n");
		}
		else {
			sb.append(0).append("\n");
		}
	}
	
	public static void front() {
		if(!deque.isEmpty()) {
			sb.append(deque.peekFirst()).append("\n");
		}
		else {
			sb.append(-1).append("\n");
		}
	}
	
	public static void back() {
		if(!deque.isEmpty()) {
			sb.append(deque.peekLast()).append("\n");
		}
		else {
			sb.append(-1).append("\n");
		}
	}

}
