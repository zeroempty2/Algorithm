import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            String[] names = new String[n];
            String[][] papers = new String[n][];
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                names[i] = line; // 이름
                List<String> msgs = new ArrayList<>();
                while (sc.hasNext()) {
                    String token = sc.next();
                    if (token.equals("P") || token.equals("N")) {
                        msgs.add(token);
                        if (msgs.size() == n - 1) break; // 메시지 수는 항상 n-1개
                    } else {
                        break;
                    }
                }
                papers[i] = msgs.toArray(new String[0]);
            }

            System.out.println("Group " + group);
            group++;

            boolean nasty = false;
            for (int i = 0; i < n; i++) {
                String owner = names[i]; // 종이 주인
                for (int j = 0; j < papers[i].length; j++) {
                    if (papers[i][j].equals("N")) {
                        int writerIdx = (i - (j + 1) + n) % n;
                        String writer = names[writerIdx];
                        System.out.println(writer + " was nasty about " + owner);
                        nasty = true;
                    }
                }
            }
            if (!nasty) {
                System.out.println("Nobody was nasty");
            }
            System.out.println();
        }
    }
}
