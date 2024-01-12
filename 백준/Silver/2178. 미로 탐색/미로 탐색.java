import java.io.*;
import java.util.*;
public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int row = Integer.parseInt(st.nextToken());
    int column = Integer.parseInt(st.nextToken());

    int[][] arr = new int[row][column];
    boolean[][] visited = new boolean[row][column];

    for(int i = 0; i < row; i++){
        st = new StringTokenizer(bf.readLine());
        String line = st.nextToken();
        for(int j = 0; j < column; j++){
            String num = line.substring(j, j + 1);
            arr[i][j] = Integer.parseInt(num);
        }
    }

    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(0, 0));
    visited[0][0] = true;

    while(!q.isEmpty()){
        Node now = q.poll();
        int nowX = now.x;
        int nowY = now.y;
        for(int k = 0; k < 4; k++){
            int newX = nowX + dx[k];
            int newY = nowY + dy[k];
            if(newX >= 0 && newY >= 0 && newX < row && newY < column){
                if(arr[newX][newY] != 0 && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    arr[newX][newY] = arr[nowX][nowY] + 1;
                    q.add(new Node(newX, newY));
                }
            }
        }
    }

    System.out.println(arr[row - 1][column -1]);

}
 static class Node{
    int x;
    int y;

    public Node(int row, int column){
        this.x = row;
        this.y = column;
    }
 }
}
