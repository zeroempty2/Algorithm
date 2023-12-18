import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    InnerMain[] arr = new InnerMain[N];
    for(int i = 0; i < N; i++){
        arr[i] = new InnerMain(Integer.parseInt(bf.readLine()), i);
    }
    Arrays.sort(arr,(i1,i2) -> i1.value - i2.value);
    int M = 0;
    for(int i = 0; i < N; i++){
        M = Math.max(M,arr[i].index - i);
    }
    System.out.println(M + 1);
}
static class InnerMain {
        int value;
        int index;

        public InnerMain(int i1, int i2){
            this.value = i1;
            this.index = i2;
        }
        
    }
}