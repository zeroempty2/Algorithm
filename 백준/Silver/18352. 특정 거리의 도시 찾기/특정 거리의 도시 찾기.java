import java.io.*;
import java.util.*;
public class Main {
    static int[] visited;
    static ArrayList<Integer>[] arr;
    static int n;
    static int m;
    static int k;
    static int x;
    static List<Integer> answer = new ArrayList<>();
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();
    
    arr = new ArrayList[n + 1];
    visited = new int[n + 1];
    Arrays.fill(visited, -1);

    for(int i = 1; i < n + 1; i++){
        arr[i] = new ArrayList<>();
    }

    for(int i = 0; i < m; i++){
        int start = sc.nextInt();
        int end = sc.nextInt();
        arr[start].add(end);
    }

    BFS(x);

    for(int i = 0; i < n + 1; i++){
        if(visited[i] == k) answer.add(i);
    }

    if(!answer.isEmpty()){
    Collections.sort(answer);
        for(int i : answer){
        System.out.println(i);
        }    
    }else{
        System.out.println(-1);
    }
    
}

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]++;
        while(!q.isEmpty()){
            int now = q.poll();   
            for(int i : arr[now]){
                if(visited[i] == -1){
                    visited[i] = visited[now] + 1;
                    q.add(i);
                }
            }
        }
    }
}
