import java.util.*;

public class Main {
    static class Balloon {
        int index;
        int move;

        Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Balloon> balloons = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            int move = sc.nextInt();
            balloons.add(new Balloon(i + 1, move));
        }

        StringBuilder sb = new StringBuilder();
        int current = 0; 
        int count = 0;

        while (count < N) {
            Balloon b = balloons.get(current);
            sb.append(b.index).append(" ");
            visited[current] = true;
            count++;

            if (count == N) break;

            int move = b.move;
            int steps = 0;

            if (move > 0) {
                while (steps < move) {
                    current = (current + 1) % N;
                    if (!visited[current]) steps++;
                }
            } else {
                while (steps > move) {
                    current = (current - 1 + N) % N;
                    if (!visited[current]) steps--;
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
