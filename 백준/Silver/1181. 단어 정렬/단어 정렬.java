import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] word = new String[N];
		
		// 단어 입력
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		
		// 정렬 구현
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length() - s2.length();
				}
			}
			
		});
		
		// 출력
		for(int i = 0; i < N - 1; i++) {
			if (word[i].compareTo(word[i + 1]) != 0) {
				sb.append(word[i]).append("\n");
			}			
		}
		
		sb.append(word[N - 1]).append("\n");
		
		System.out.println(sb);
		
	}

}
