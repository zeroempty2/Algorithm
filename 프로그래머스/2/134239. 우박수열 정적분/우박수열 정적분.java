import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> collatz = new ArrayList<>();
    static List<Double> graphArea = new ArrayList<>();
    static double[] answer;

    public double[] solution(int k, int[][] ranges) {
        answer = new double[ranges.length];
        graphArea.add(0.0);

        collatzGuess(k);
        calculateArea();
        cumulativeSum();
        integral(ranges);

        return answer;
    }

    private void collatzGuess(int k){
        collatz.add(k);
        if(k == 1) return;
        int collatzNum = k % 2 == 0 ? k / 2 : k * 3 + 1;
        collatzGuess(collatzNum);
    }

    private void calculateArea(){
        for(int i = 0; i < collatz.size() - 1; i++){
            int maxNum = Math.max(collatz.get(i), collatz.get(i + 1));
            double area = maxNum - ((double)(Math.abs(collatz.get(i + 1) - collatz.get(i))) / 2);
            graphArea.add(area);
        }
    }

    private void cumulativeSum(){
        for (int i = 1; i < graphArea.size(); i++) {
            graphArea.set(i, graphArea.get(i - 1) + graphArea.get(i));
        }
    }

    private void integral(int[][] ranges){
        for (int i = 0; i < ranges.length; i++) {
            int s = ranges[i][0];
            int e = collatz.size() - 1 + ranges[i][1];
            if (e > s) {
                answer[i] = graphArea.get(e) - graphArea.get(s);
            } else if (s > e) {
                answer[i] = -1.0;
            }
        }
    }
}