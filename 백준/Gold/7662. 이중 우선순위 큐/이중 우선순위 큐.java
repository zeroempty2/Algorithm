import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int k = Integer.parseInt(bf.readLine()); // 연산의 개수
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 최소 힙
            HashMap<Integer, Integer> countMap = new HashMap<>(); // 값의 유효성 저장

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    // 삽입 연산
                    maxPQ.add(value);
                    minPQ.add(value);
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                } else {
                    // 삭제 연산
                    if (value == 1) {
                        // 최댓값 삭제
                        removeInvalid(maxPQ, countMap);
                        if (!maxPQ.isEmpty()) {
                            int max = maxPQ.poll();
                            countMap.put(max, countMap.get(max) - 1);
                            if (countMap.get(max) == 0) {
                                countMap.remove(max);
                            }
                        }
                    } else {
                        // 최솟값 삭제
                        removeInvalid(minPQ, countMap);
                        if (!minPQ.isEmpty()) {
                            int min = minPQ.poll();
                            countMap.put(min, countMap.get(min) - 1);
                            if (countMap.get(min) == 0) {
                                countMap.remove(min);
                            }
                        }
                    }
                }
            }

            // 최종 결과 계산
            removeInvalid(maxPQ, countMap);
            removeInvalid(minPQ, countMap);

            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxPQ.peek()).append(" ").append(minPQ.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    // 유효하지 않은 값 제거 (최대/최소 힙 동기화)
    static void removeInvalid(PriorityQueue<Integer> pq, HashMap<Integer, Integer> countMap) {
        while (!pq.isEmpty() && (!countMap.containsKey(pq.peek()) || countMap.get(pq.peek()) == 0)) {
            pq.poll();
        }
    }
}
