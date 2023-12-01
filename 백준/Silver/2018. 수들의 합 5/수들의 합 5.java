import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.close();
    int answer = 1;
    int start = 1;
    int end = 1;
    int sum = 1;
    while(end != N){
        if(sum == N){
            answer++;
            end++;
            sum += end;
            continue;
        }
        if(sum > N){
            sum -= start;
            start++;
            continue;
        }
        end++;
        sum += end;
    }
    System.out.println(answer);
}
}