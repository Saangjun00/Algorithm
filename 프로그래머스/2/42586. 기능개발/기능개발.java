import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        int[] day = new int[progresses.length];
        for(int i = 0; i < day.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                day[i] = (100 - progresses[i]) / speeds[i];
            } 
            else {
                day[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
            
            queue.add(day[i]);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        int devday = queue.peek();
        
        while(!queue.isEmpty()) {
            if(queue.peek() <= devday) {
                queue.poll();
                count++;
            }
            else {
                list.add(count);
                count = 1;
                devday = queue.poll();
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}