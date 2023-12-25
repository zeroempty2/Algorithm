class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
        int[][] graph = new int[n][n];
        
        for (int[] result : results) {
            graph[result[1] - 1][result[0] - 1] = -1; // 패배
            graph[result[0] - 1][result[1] - 1] = 1;  // 승리
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean determined = true;
            for (int j = 0; j < n; j++) {
                if (i != j && graph[i][j] == 0) {
                    determined = false;
                    break;
                }
            }
            if (!determined) {
                answer--;
            }
        }

        return answer;
    }
}