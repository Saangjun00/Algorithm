class Solution {
    public int solution(int age) {
        int answer = 0;
        
        final int standardYear = 2022;
        
        answer = age - standardYear;
        answer = Math.abs(answer) + 1;
        
        return answer;
    }
}