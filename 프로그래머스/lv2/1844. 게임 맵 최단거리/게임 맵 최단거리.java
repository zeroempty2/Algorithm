import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] maps) {
        int mapX = maps[0].length;
        int mapY = maps.length;
        
        Queue<pointer> q = new LinkedList<>();
        q.add(new pointer(0,0,1));

        while (!q.isEmpty()) {
            pointer p = q.poll();
            int x = p.x;
            int y = p.y;
            int knowWhere = p.where;

            if (x == mapX - 1 && y == mapY - 1) {
                return knowWhere;
            }

            for (int[] dir : directions) {
                int newX = x + dir[1];
                int newY = y + dir[0];

                if (newY >= 0 && newY < mapY && newX >= 0 && newX < mapX && maps[newY][newX] == 1) {
                    maps[newY][newX] = 0; 
                    q.add(new pointer(newX, newY, knowWhere + 1));
                }
            }

        }

        return -1;
    }
    
    public class pointer {
    int x;
    int y;
    int where;

    public pointer(int x, int y, int where){
        this.x = x;
        this.y = y;
        this.where = where;
    }
}

}