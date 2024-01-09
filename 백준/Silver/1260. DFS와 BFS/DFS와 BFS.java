import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> dfsList = new ArrayList<>();
    static ArrayList<Integer> bfsList = new ArrayList<>();
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int node = Integer.parseInt(st.nextToken());
    int edge = Integer.parseInt(st.nextToken());
    int startPoint  = Integer.parseInt(st.nextToken());
    graph = new ArrayList[node + 1];
    for(int i = 1; i <= node; i++){
        graph[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i < edge; i++){
        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        graph[start].add(end);
        graph[end].add(start);
    }
    for(int i = 1; i <= node; i++){
        Collections.sort(graph[i]);
    }
    visited = new boolean[node + 1];
    dfs(startPoint);
    visited = new boolean[node + 1];
    bfs(startPoint);
    for(int i : dfsList){
        bw.write(i + " ");
    }
    bw.flush();
    System.out.println();
    for(int i : bfsList){
        bw.write(i + " ");
    }
    bw.flush();
}

    static void dfs(int n){
        dfsList.add(n);
        visited[n] = true;
        for(int i : graph[n]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            bfsList.add(now);
            for(int i : graph[now]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
