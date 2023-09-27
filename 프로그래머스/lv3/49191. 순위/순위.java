class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
        int[][] graph = new int[n][n];

        for(int i = 0; i < results.length; i++){
            graph[results[i][1] - 1][results[i][0] - 1] = -2; 
            graph[results[i][0] - 1][results[i][1] - 1] = 2; 
        }

        for(int i = 0; i < n; i++){
            graph[i][i] = 1;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(graph[j][i] == 2 && graph[i][k] == 2){
                        graph[j][k] = 2;
                        graph[k][j] = -2;
                    } 
                }
            }
        }

        for(int[] g : graph){
            for(int f : g){
                if(f == 0){
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}