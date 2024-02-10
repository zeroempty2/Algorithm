import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int visited[];
	static boolean visit[];
	static int check[];
	static boolean isTrue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visited = new int[v + 1];
			arr = new ArrayList[v + 1];
			visit = new boolean[v + 1];
			check = new int[v + 1];
			isTrue = true;
			for(int j = 0; j < v + 1; j++) arr[j] = new ArrayList<Integer>();

			for(int k = 0; k < e; k++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				arr[start].add(end);
				arr[end].add(start);
			}
			for(int t = 1; t < v + 1; t++){
				if(isTrue) dfs(t);
				else break;
			}
			System.out.println(isTrue ? "YES" : "NO");
		}
	}

	public static void dfs(int node){
		visit[node] = true;
		for(int i : arr[node]){
			if(!visit[i]){
				check[i] = (check[node] + 1) % 2;
				dfs(i);
			}
			else if(check[node] == check[i]){
				isTrue = false;
			}
		}
		
	}
}