import java.io.*;
import java.util.*;
public class Main{
	static int[][] route = new int[][]{{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};
	static boolean[][] visited = new boolean[201][201];
	static boolean[] answer = new boolean[201];
	static int now[] = new int[3];
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
	now[0] = Integer.parseInt(st.nextToken());
	now[1] = Integer.parseInt(st.nextToken());
	now[2] = Integer.parseInt(st.nextToken());
	bfs();
	for(int i = 0; i < 201; i++){
		if(answer[i]) System.out.print(i + " ");
	}
}

public static void bfs(){
	Queue<int[]> q = new LinkedList<>();
	q.add(new int[]{0,0});
	visited[0][0] = true;
	answer[now[2]] = true;
	while(!q.isEmpty()){
		int[] p = q.poll();
		int a = p[0];
		int b = p[1];
		int c = now[2] - a - b;
		for(int k = 0; k < 6; k++){
			int[] next = {a,b,c};
			int send = route[k][0];
			int receive = route[k][1];

			next[receive] += next[send];
			next[send] = 0;

			if (next[receive] > now[receive]) {
				next[send] = next[receive] - now[receive];
				next[receive] = now[receive];
			}

			if(!visited[next[0]][next[1]]){
				visited[next[0]][next[1]] = true;
				q.add(new int[]{next[0],next[1]});
				if(next[0] == 0) answer[next[2]] = true;
			}
		}
	}
}
}
