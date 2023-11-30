import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] 구간합 = new long[N];
    long[] 나머지 = new long[M];
    구간합[0] = sc.nextInt();
    long answer = 0;
    for(int i = 1; i < N; i++){
        구간합[i] = 구간합[i - 1] + sc.nextInt();
    }
    sc.close();
    for(int i = 0; i < N; i++){
        int 나머지계산 = (int)(구간합[i] % M);
        if(나머지계산 == 0) answer++;
        나머지[나머지계산]++;
    }
    for(int i = 0; i < 나머지.length; i++){
        if(나머지[i] > 1){
            answer += (나머지[i] * (나머지[i] - 1)) / 2;
        }
    }
    System.out.println(answer);
}
}