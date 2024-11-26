import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");
        for(int i = 0; i < n; i++){
            q.add(i+1);
        }
        while(!q.isEmpty()){
            for(int j = 0; j < k - 1; j++){
                q.add(q.poll());
            }

            sb.append(String.valueOf(q.poll())+", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
      }
  }