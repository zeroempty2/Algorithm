import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,0});

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == x){
                return now[1];
            }
            if(now[0] > x){
                if(now[0] % 3 == 0){
                    q.add(new int[]{now[0]/3,now[1] + 1});
                }
                if(now[0] % 2 == 0){
                    q.add(new int[]{now[0]/2,now[1] + 1});
                }
                q.add(new int[]{now[0] - n,now[1] + 1});
            }
        }
        return answer;
    }
}