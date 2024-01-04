import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        for(int i = 1; i < node + 1; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edge; i++){
           st = new StringTokenizer(bf.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           arr[start].add(end);
           arr[end].add(start);
        }
        int cnt = 0;
        for(int i = 1; i < node + 1; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int node : arr[i]){
            if(visited[node] == false){
                dfs(node);
            }
        }
    }
}
