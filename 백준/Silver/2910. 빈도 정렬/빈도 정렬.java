import java.util.*;

public class Main {
    static class Number {
        int value;
        int index;

        Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Number> list = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            list.add(new Number(num, i));
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            firstIndex.putIfAbsent(num, i);
        }

        list.sort((a, b) -> {
            int freqA = freq.get(a.value);
            int freqB = freq.get(b.value);
            if (freqA != freqB) {
                return freqB - freqA; 
            } else {
                return firstIndex.get(a.value) - firstIndex.get(b.value); 
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Number n : list) {
            sb.append(n.value).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
