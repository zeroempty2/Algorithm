import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); 

        while (T-- > 0) {
            String[] recorded = sc.nextLine().split(" "); 
            Set<String> knownSounds = new HashSet<>();

     
            while (true) {
                String line = sc.nextLine();
                if (line.equals("what does the fox say?")) break;

                String[] parts = line.split(" ");
                knownSounds.add(parts[2]); 
            }

            StringBuilder result = new StringBuilder();
            for (String word : recorded) {
                if (!knownSounds.contains(word)) {
                    result.append(word).append(" ");
                }
            }

            System.out.println(result.toString().trim());
        }
    }
}
