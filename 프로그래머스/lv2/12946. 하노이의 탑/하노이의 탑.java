import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};
        dfs(n, 1, 3, 2);
        answer = list.toArray(new int[list.size()][]);
        return answer;
    }

    static void dfs(int n, int start, int end, int mid) {
        if(n == 1){
            list.add(new int[]{start, end});
            return;
        }
        dfs(n-1, start, mid, end);
        list.add(new int[]{start, end});
        dfs(n-1, mid, end, start);
    }
}  