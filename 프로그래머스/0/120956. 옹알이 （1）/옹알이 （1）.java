class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] arr = {"aya", "ye", "woo", "ma"};
        for (String word : babbling) {
            if (isValid(word, arr)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isValid(String word, String[] arr) {
        String prev = "";
        int index = 0;
        
        while (index < word.length()) {
            boolean isFound = false;    // 이전 단어가 옹알이가 맞은지 체크하는 변수
            
            for (String pattern : arr) {
                if (word.startsWith(pattern, index)) {
                    if (pattern.equals(prev)) {
                        return false;
                    }
                    
                    index += pattern.length();
                    prev = pattern;
                    isFound = true;
                    break;
                }
            }
            
            // 옹알이를 찾지 못했으면
            if (!isFound) {
                return false;
            }
        }
        
        return true;    // 모든 조건이 통과하는 경우
    }
}