import java.util.*;

public class Main {
    static int toX(String s) { return s.charAt(0) - 'A'; }
    static int toY(String s) { return s.charAt(1) - '1'; }
    static String toPos(int x, int y) { return "" + (char)('A' + x) + (y + 1); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String kingPos = sc.next();
        String stonePos = sc.next();
        int n = sc.nextInt();

        int kx = toX(kingPos);
        int ky = toY(kingPos);
        int sx = toX(stonePos);
        int sy = toY(stonePos);

        Map<String, int[]> moves = new HashMap<>();
        moves.put("R", new int[]{1, 0});
        moves.put("L", new int[]{-1, 0});
        moves.put("B", new int[]{0, -1});
        moves.put("T", new int[]{0, 1});
        moves.put("RT", new int[]{1, 1});
        moves.put("LT", new int[]{-1, 1});
        moves.put("RB", new int[]{1, -1});
        moves.put("LB", new int[]{-1, -1});

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            int[] d = moves.get(cmd);
            int nkx = kx + d[0];
            int nky = ky + d[1];

            if (nkx < 0 || nkx >= 8 || nky < 0 || nky >= 8) continue; 

            if (nkx == sx && nky == sy) { // 돌과 충돌
                int nsx = sx + d[0];
                int nsy = sy + d[1];
                if (nsx < 0 || nsx >= 8 || nsy < 0 || nsy >= 8) continue; 
                sx = nsx;
                sy = nsy;
            }
            kx = nkx;
            ky = nky;
        }

        System.out.println(toPos(kx, ky));
        System.out.println(toPos(sx, sy));
    }
}
