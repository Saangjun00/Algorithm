import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        
        int maxCount = 0;
        boolean isUnique = true;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            
            if (count > maxCount) {
                maxCount = count;
                answer = key;
                isUnique = true;
            }
            
            else if (count == maxCount) {
                isUnique = false;
            }
        }
        
        if (isUnique) {
            return answer;
        }
        
        else {
            return -1;
        }
    }
}