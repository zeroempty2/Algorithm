import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String cmd = sc.next();
        
        int x = 0, y = 0;
        int dir = 2; // 처음 방향: 남쪽
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{x, y});
        
        for (int i = 0; i < len; i++) {
            char c = cmd.charAt(i);
            if (c == 'F') {
                x += dx[dir];
                y += dy[dir];
                path.add(new int[]{x, y});
            } else if (c == 'L') {
                dir = (dir + 3) % 4; // 왼쪽 회전
            } else if (c == 'R') {
                dir = (dir + 1) % 4; // 오른쪽 회전
            }
        }
        
        // 좌표 범위 계산
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        for (int[] p : path) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        // 지도 생성
        int rows = maxX - minX + 1;
        int cols = maxY - minY + 1;
        char[][] map = new char[rows][cols];
        for (char[] row : map) Arrays.fill(row, '#');
        
        for (int[] p : path) {
            int r = p[0] - minX;
            int c = p[1] - minY;
            map[r][c] = '.';
        }
        
        // 출력
        for (char[] row : map) {
            System.out.println(new String(row));
        }
    }
}
