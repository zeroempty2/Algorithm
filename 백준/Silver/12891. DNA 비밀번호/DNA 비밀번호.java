import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
    static int answer = 0;
    static int[] ACGT = new int[4];
    static int[] thisArr = new int[4];
    static int thisSum = 0;
    public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int arrLength = Integer.parseInt(st.nextToken());
    int readLength = Integer.parseInt(st.nextToken());
    arr = new char[arrLength];

    arr = bf.readLine().toCharArray();

    st = new StringTokenizer(bf.readLine());
    
    for(int i = 0; i < 4; i++){
      ACGT[i] = Integer.parseInt(st.nextToken());
      if(ACGT[i] == 0) thisSum++;
    }

    
    for(int i = 0; i < readLength; i++){
      add(arr[i]);
    }

    if(thisSum == 4) answer++;

    for(int j = readLength; j < arrLength; j++){
       add(arr[j]);
       remove(arr[j-readLength]);
        if(thisSum == 4){
          answer++;
        }
      }
    System.out.println(answer);
}

    static void add(char c){
      switch (c) {
          case 'A': 
            thisArr[0]++;
            if(thisArr[0] == ACGT[0]){
              thisSum++;
            }
            break;
          case 'C': 
            thisArr[1]++;
            if(thisArr[1] == ACGT[1]){
              thisSum++;
            }
            break;
          case 'G': 
            thisArr[2]++;
            if(thisArr[2] == ACGT[2]){
              thisSum++;
            }
            break;
          case 'T': 
            thisArr[3]++;
            if(thisArr[3] == ACGT[3]){
              thisSum++;
            }
            break;
        }
    }

     static void remove(char c){
      switch (c) {
          case 'A': 
            if(thisArr[0] == ACGT[0]){
              thisSum--;
            }
            thisArr[0]--;
            break;
          case 'C': 
            if(thisArr[1] == ACGT[1]){
              thisSum--;
            }
            thisArr[1]--;
            break;
          case 'G': 
            if(thisArr[2] == ACGT[2]){
              thisSum--;
            }
            thisArr[2]--;
            break;
          case 'T': 
            if(thisArr[3] == ACGT[3]){
              thisSum--;
            }
            thisArr[3]--;
            break;
        }
    }

}
