import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int[] info = new int[N];
        for (int i = 0; i < N; i++) {
            info[i] = Integer.parseInt(tokens[i]);
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int taller = info[i];  
            int height = i + 1;

            int count = 0;
            for (int j = 0; j < N; j++) {
                if (result[j] == 0) {  
                    if (count == taller) {
                        result[j] = height;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
