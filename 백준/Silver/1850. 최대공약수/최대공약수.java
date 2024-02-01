import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long result = gdc(a, b);
    for(int i = 0; i < result; i++){
        bw.write("1");
    }
    bw.flush();
    bw.close();
}
    static long gdc(long a,long b){
        if(b == 0) return a;
        return gdc(b, a % b);
    }
       
}
