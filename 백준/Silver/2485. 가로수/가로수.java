import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] pos = new int[N];
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = pos[i + 1] - pos[i];
        }

        int gcd = diff[0];
        for (int i = 1; i < diff.length; i++) {
            gcd = getGCD(gcd, diff[i]);
        }

        int totalTrees = (pos[N - 1] - pos[0]) / gcd + 1;

        int answer = totalTrees - N;
        System.out.println(answer);
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
