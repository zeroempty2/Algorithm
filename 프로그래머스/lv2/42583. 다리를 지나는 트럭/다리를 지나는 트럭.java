import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> move = new LinkedList<>();

        for (int t : truckWeights) {
            wait.add(new Truck(t));
        }

        int answer = 0;
        int bridgeWeight = 0;

        while (!wait.isEmpty() || !move.isEmpty()) {
            answer++;

            if (move.isEmpty()) {
                Truck t = wait.poll();
                bridgeWeight += t.weight;
                move.add(t);
            }
            else{
                for (Truck t : move) {
                t.moving();
                }

                if (move.peek().move > bridgeLength) {
                    Truck t = move.poll();
                    bridgeWeight -= t.weight;
                }

                if (!wait.isEmpty() && bridgeWeight + wait.peek().weight <= weight) {
                    Truck t = wait.poll();
                    bridgeWeight += t.weight;
                    move.add(t);
                }
            }
        }

        return answer;
    }

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }
}