import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	arr = new int[n + 1];

	for(int i = 1; i < n + 1; i++) arr[i] = i;

	for(int i = 0; i < m; i++){
		st = new StringTokenizer(bf.readLine());
		int type = Integer.parseInt(st.nextToken());
		int firstValue = Integer.parseInt(st.nextToken());
		int secondValue = Integer.parseInt(st.nextToken());

		if(type == 0){
			union(firstValue, secondValue);
			continue;
		}
		
		System.out.println(check(firstValue, secondValue) ? "YES" : "NO");
		
	}
   
}

	private static void union(int first, int second){
		first = find(first);
		second = find(second);
		if(first != second) arr[second] = first;
	}

	private static int find(int a){
		if(arr[a] == a) return a;
		else return arr[a] = find(arr[a]);
	}
	
	private static boolean check(int a, int b){
		a = find(a);
		b = find(b);
		return a == b;
	}
}
