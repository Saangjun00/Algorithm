class Solution {
    public int solution(int num1, int num2) {
        double result = (double) num1 / num2;
        int answer = (int)(result * 1000);
        
        return answer;
    }
}