import java.util.LinkedList;
import java.util.Stack;

class Solution {
    char[][] arr;
    Stack<String> st = new Stack<>();
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        for(int i = 0; i < board.length; i++) {
            arr[i] = board[i].toCharArray();
            st.add(board[i]);
        }
        boolean stop = false;
        while(true){
            stop = true;
            int col = board.length - 1;
            while(true){
            char[] cArr = st.pop().toCharArray();
            if(st.isEmpty()) break;
            for(int j = 1; j < cArr.length; j++){
                if(cArr[j-1] == cArr[j]){
                   char[] nextArr = st.peek().toCharArray();
                   if(cArr[j] == cArr[j-1] && nextArr[j] == nextArr[j-1] && cArr[j] == nextArr[j] && cArr[j] != 0 && cArr[j-1] != 0){
                    arr[col][j-1] = 0;
                    arr[col][j] = 0;
                    arr[col-1][j-1] = 0;
                    arr[col-1][j] = 0;
                    stop = false;
                   }
                }
            }
            col--;
        }
        if(stop) break;
        arrSort();
        }
        for(char[] ca : arr){
             for(char c : ca) if(c == 0) answer++; 
        }
        return answer;
    }

    void arrSort(){
        int col = arr.length - 1;
        for(int i = col; i > 0; i--){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    for(int k = i - 1; k >= 0; k--){
                        if(arr[k][j] != 0){
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
        for(int n = 0; n < arr.length; n++) {
        st.add(String.valueOf(arr[n]));
        }
    }
}