import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    for(int i = 0; i < n; i++){
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = a * b / gdc(a, b);
        System.out.println(result);
    }
}
    static int gdc(int a,int b){
        if(b == 0) return a;
        return gdc(b, a % b);
    }
       
}
