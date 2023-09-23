import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] start = {};
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;

        findStart(board);

        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;

        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(start[0], start[1], 0));

        while(!q.isEmpty()){
            Location lc = q.poll();

            // if(answer <= lc.moveCount) continue;
            
            if (board[lc.x].charAt(lc.y) == 'G') {
                answer = Math.min(answer, lc.moveCount);
            }
            else{
                for (int i = 0; i < 4; i++) {
                    int x = lc.x + X[i];
                    int y = lc.y + Y[i];
                    
                    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length()) continue;
                
                    if (board[x].charAt(y) == 'D') continue;
                    
                    while(x >= 0 
                       && y >= 0 
                       && x < board.length 
                       && y < board[0].length()
                       && board[x].charAt(y) != 'D') {
                        x += X[i];
                        y += Y[i];
                    }
                    
                    x -= X[i];
                    y -= Y[i];

                    if (visited[x][y]) continue;
                    
                    visited[x][y] = true;
                    
                    q.offer(new Location(x, y, lc.moveCount + 1));
                }
            }
            
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void findStart(String[] board){
        for(int i = 0; i < board.length; i++){
            String element = board[i];
            for(int j = 0; j < element.length(); j++){
                if(element.charAt(j) == 'R'){
                    start = new int[]{i,j};
                    break;
                }
            }
        }
    }

    class Location {
        int x;
        int y;
        int moveCount;
        
        public Location(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }
}