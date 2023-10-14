import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int pick = crane(board, 0, moves[i] - 1);
            if(pick == -1) continue;
            if(!st.empty()){
                if(st.peek() == pick) {
                    st.pop();
                    answer += 2;
                }
                else st.add(pick);
            }
            else st.add(pick);
        }
        return answer;
    }
    public int crane(int[][] board, int depth, int move){
        if(depth >= board.length) return -1;
        if(board[depth][move] == 0){
            return crane(board, depth + 1, move);
        }
        int pickUp = board[depth][move];
        board[depth][move] = 0;
        return pickUp;
    }
}