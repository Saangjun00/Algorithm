import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Member[] member = new Member[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			member[i] = new Member(age, name);
		}
		
		Arrays.sort(member, new Comparator<Member>() {
			@Override
			public int compare(Member s1, Member s2) {
				return s1.age - s2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(member[i]);
		}
		
		System.out.println(sb);

	}
	
	public static class Member {
		int age;
		String name;
		
		Member(int age, String name){
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}

}


