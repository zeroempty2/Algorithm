import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] arr = new int[N][2];

    for(int i = 0; i < N; i++){
        arr[i][0] = sc.nextInt();
        arr[i][1] = sc.nextInt();
    }

    Arrays.sort(arr,new Comparator<int[]>() {
        @Override
        public int compare(int[] s, int[] e){
            if(s[1] == e[1]){
                return s[0] - e[0];
            }
            return s[1] - e[1];
        }
    });

    int ans = 0;
    int end = -1;
    for(int[] a : arr){
        if(a[0] >= end){
            end = a[1];
            ans++;
        }
    }

    System.out.println(ans);
}

}
