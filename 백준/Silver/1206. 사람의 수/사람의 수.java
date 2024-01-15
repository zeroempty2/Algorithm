import java.io.*;
import java.util.*;
public class Main {
    static int[] averages;
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    averages = new int[n];

    for(int i = 0; i < n; i++){
        String[] input = br.readLine().split("\\.");
        StringBuilder sb = new StringBuilder();
        sb.append(input[0]).append(input[1]);
        averages[i] = Integer.parseInt(sb.toString());
    }

    for(int i = 1; i < 1001; i++){
        if(isPossible(i)){
            System.out.println(i);
            break;
        }
    }

}
static boolean isPossible(int i){
    for (int avg : averages) {
        int left = 0;
        int right = 10 * i;
        boolean isPossible = false;
        while (left <= right) {
            int sumOfScore = (left + right) / 2;
            int currentAvg = (sumOfScore * 1000) / i;

            if (currentAvg == avg) {
                if (currentAvg > 10 * 1000) continue;
                isPossible = true;
                break;
            } 
            else if (currentAvg > avg) right = (sumOfScore - 1);
            else left = (sumOfScore + 1);   
        }
        if (!isPossible) return false;  
    }
    return true;
}
// static boolean binarySearch(int left, int right, int i, int avg){
//     if(left > right){
//         return false;
//     }
//     int mid = (left + right) / 2;
//     int currentAvg = (mid * 1000) / i;
//     if(currentAvg == avg && currentAvg < 10 * 1000) return true;
//     else if (currentAvg > avg) return binarySearch(left, mid - 1, i, avg);
//     else return binarySearch(mid + 1, right, i, avg); 
// }
}