import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> scores = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine());
            scores.add(new int[]{score, i});  
        }
        scores.sort((a, b) -> b[0] - a[0]);
        int total = 0;
        List<Integer> selectedProblems = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            total += scores.get(i)[0];
            selectedProblems.add(scores.get(i)[1]);
        }
        Collections.sort(selectedProblems);
        System.out.println(total);
        for (int i : selectedProblems) {
            System.out.print(i + " ");
        }
    }
}
