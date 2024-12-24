import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int j = 0; j < M; j++){
            String[] arr = bf.readLine().split(" ");
            int e = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            graph.get(e).add(v);
            graph.get(v).add(e);

        }

        boolean[] visited = new boolean[N + 1];

        System.out.println(dfs(1, graph, visited) - 1);
      }

      private static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1; 

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
    }

}
