import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static ArrayList<Node>[] arr;
    static int[] distance;
    static int N;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int M = 1;
    arr = new ArrayList[N + 1];

    for(int i = 1; i < N + 1; i++){
        arr[i] = new ArrayList<Node>();
    }
    
    for(int i = 0; i < N; i++){
        int start = sc.nextInt();
        while(true){
            int end = sc.nextInt();
            if(end == -1){
                break;
            }
            int value = sc.nextInt();
            arr[start].add(new Node(end, value));
        }
    }

    bfs(M);

    for(int i = 2; i < N + 1; i++){
        if(distance[M] < distance[i]){
            M = i;
        }
    }

    bfs(M);

    Arrays.sort(distance);
    System.out.println(distance[N]);
}

 static void bfs(int index){
    distance = new int[N + 1];
    visited = new boolean[N + 1];
    Queue<Integer> q = new LinkedList<>();
    q.offer(index);
    visited[index] = true;

    while(!q.isEmpty()){
       int now = q.poll();
       for(Node n : arr[now]){
            int edge = n.edge;
            int value = n.value;
            if(!visited[edge]){
                visited[edge] = true;
                q.add(edge);
                distance[edge] = distance[now] + value;
            }
       }
    }
 }

 static class Node{
    int edge,value;

    public Node(int edge, int value){
        this.edge = edge;
        this.value = value;
    }
 }
}
