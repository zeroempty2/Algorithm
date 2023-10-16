import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> lowest = new PriorityQueue<>();
        PriorityQueue<Integer> highest = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations){
            if(operation.equals("D 1") && !highest.isEmpty()){
                lowest.remove(highest.poll());
            }
            if(operation.equals("D -1") && !lowest.isEmpty()){
                highest.remove(lowest.poll());
            }
            if(!operation.equals("D -1") && !operation.equals("D 1")){
                int number = Integer.parseInt(operation.split(" ")[1]);
                lowest.offer(number);
                highest.offer(number);
            }
        }
        return new int[]{highest.isEmpty() ? 0 : highest.poll(), lowest.isEmpty() ? 0 : lowest.poll()};
    }
}