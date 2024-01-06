import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean isTrue = false;
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int node = Integer.parseInt(st.nextToken());
    int edge = Integer.parseInt(st.nextToken());
    graph = new ArrayList[node];
    visited = new boolean[node];
    for(int i = 0; i < node; i++){
        graph[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i < edge; i++){
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph[start].add(end);
        graph[end].add(start);
    }
    for(int i = 0; i < node; i++){
        dfs(i, 1);
        if(isTrue) break;
    }
    System.out.println(isTrue ? "1" : "0");
}
    static void dfs(int n,int depth){
        if(depth == 5 || isTrue){
            isTrue = true;
            return;
        }
        visited[n] = true;
        for(int i : graph[n]){
            if(!visited[i]){
                dfs(i,depth + 1);
            }
        }
        visited[n] = false;
    }
}
