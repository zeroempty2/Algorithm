import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < N; i++){
          st = new StringTokenizer(bf.readLine());
          set.add(st.nextToken());
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(bf.readLine());
            String m = st.nextToken();
            if(set.contains(m)){
                count++;
                list.add(m);
            }
        }
        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(count));
        sb.append("\n");
        for(String s : list){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
      }
}
