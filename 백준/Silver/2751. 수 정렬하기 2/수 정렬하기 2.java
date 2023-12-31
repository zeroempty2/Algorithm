import java.io.*;
import java.util.*;
public class Main {
    static int[] answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    answer = new int[N + 1];
    arr = new int[N + 1];
    for(int i = 1; i < N + 1; i++){
        answer[i] = Integer.parseInt(br.readLine());
    }
    mSort(1, N);
    for(int i = 1; i < N + 1; i++){
        bw.write(answer[i] + "\n");
    }
    bw.flush();
    bw.close();
    
    }
    private static void mSort(int start, int end){
        if(end - start < 1) return;
        int middle = start + (end - start) / 2;

        mSort(start, middle);
        mSort(middle + 1, end);

        for(int i = start; i < end + 1; i++){
            arr[i] = answer[i];
        }

        int k = start;
        int index1 = start;
        int index2 = middle + 1;

        while(index1 < middle + 1 && index2 < end + 1){
            if(arr[index1] > arr[index2]){
                answer[k] = arr[index2];
                k++;
                index2++;
            }
            else{
                answer[k] = arr[index1];
                k++;
                index1++;
            }
        }
        while(index1 < middle + 1){
            answer[k] = arr[index1];
            k++;
            index1++;
        }
        while(index2 < end + 1){
            answer[k] = arr[index2];
            k++;
            index2++;
        }
    }
}
