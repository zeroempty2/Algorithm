class Solution{
    public int solution(int [][]board){
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        int answer = 0;
        for(int i = 1; i < board.length + 1; i++){
            for(int j = 1; j < board[0].length + 1; j++){
                if(board[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                }
                if(dp[i][j] > answer){
                    answer = dp[i][j];
                }
            }
        }
        return answer*answer;
    }
}