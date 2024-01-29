import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] alphabet = new int[26];	//알파벳 개수만큼 배열 선언
		
		// 대문자로 출력하므로 입력을 대문자로 받기
		String str = scan.next().toUpperCase();
		
		for(int i = 0; i < str.length(); i++) {	// 입력한 알파벳 개수 확인
			int tempNum = str.charAt(i) - 65;	// 값을 하나씩 가져와서 대문자 - A
			alphabet[tempNum]++;	// 해당 위치에 ++
		}
		
		int max = -1;	// 배열 안에 초기 값이 0이므로 -1로 지정
		char ch = '?';
		for(int i = 0; i < alphabet.length; i++) {	// 최대값 찾기
			if(alphabet[i] > max) {
				max = alphabet[i];
				ch = (char)(i + 65);
			}
			else if(alphabet[i] == max) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
	}

}
