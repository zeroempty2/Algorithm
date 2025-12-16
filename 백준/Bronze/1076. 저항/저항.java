import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();

        Map<String, Integer> value = new HashMap<>();
        Map<String, Long> mul = new HashMap<>();

        value.put("black", 0);
        value.put("brown", 1);
        value.put("red", 2);
        value.put("orange", 3);
        value.put("yellow", 4);
        value.put("green", 5);
        value.put("blue", 6);
        value.put("violet", 7);
        value.put("grey", 8);
        value.put("white", 9);

        mul.put("black", 1L);
        mul.put("brown", 10L);
        mul.put("red", 100L);
        mul.put("orange", 1_000L);
        mul.put("yellow", 10_000L);
        mul.put("green", 100_000L);
        mul.put("blue", 1_000_000L);
        mul.put("violet", 10_000_000L);
        mul.put("grey", 100_000_000L);
        mul.put("white", 1_000_000_000L);

        long resistance = (value.get(c1) * 10L + value.get(c2)) * mul.get(c3);
        System.out.println(resistance);
    }
}
