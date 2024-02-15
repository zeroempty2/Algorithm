import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int[][] city  = new int[n + 1][n + 1];

	for(int i = 1; i < n + 1; i++)
		for(int j = 1; j < n + 1; j++)
			city[i][j] = sc.nextInt();
		
	int[] route = new int[m + 1];
	
	for(int i = 1; i < m + 1; i++) route[i] = sc.nextInt();

	arr = new int[n + 1];

	for(int i = 1; i < n + 1; i++) arr[i] = i;

	for(int i = 1; i < n + 1; i++)
		for(int j = 1; j < n + 1; j++)
			if(city[i][j] == 1) union(i, j);
	
	int index = find(route[1]);

	for(int i = 2; i < route.length; i++){
		if(index != find(route[i])) {
			System.out.println("NO");
			return;
		}
	}

	System.out.println("YES");
	
}

	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a != b) arr[b] = a;
	}

	static int find(int a){
		if(a == arr[a]) return a;
		else return arr[a] = find(arr[a]);
	}

}

