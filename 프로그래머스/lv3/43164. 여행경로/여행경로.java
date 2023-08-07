import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }

    private static void dfs(int cnt, String now, String next, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(next);
        }else{
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(now)) {
                    visited[i] = true;
                    dfs(cnt + 1,tickets[i][1],next + " " + tickets[i][1],tickets);
                    visited[i] = false;
                }
            }
        }
    }
}