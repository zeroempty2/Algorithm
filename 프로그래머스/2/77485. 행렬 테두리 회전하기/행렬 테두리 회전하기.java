class Solution {
    static int[][] arr;
    static int begin;
    static int min;
    static int[][] point = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    static int row, column; // 2 - 1 - 4 - 3
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows + 1][columns + 1];

        int number = 1;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                arr[i][j] = number;
                number++;
            }
        }
            

        for(int i = 0; i < queries.length; i++){
            min = Integer.MAX_VALUE;
            begin = arr[queries[i][0]][queries[i][1]];
            row = queries[i][0];
            column = queries[i][1];

            int idx = 0;
            while(true){
                min = Math.min(min,begin);

                int again = arr[row][column];
                arr[row][column] = begin;
                begin = again;

                row += point[idx][0];
                column += point[idx][1];

                if(row > queries[i][2]){
                    idx++;
                    row--;
                    column--;
                }
                else if(column > queries[i][3]){
                    idx++;
                    column--;
                    row++;
                }
                else if(column < queries[i][1]){
                    idx++;
                    column++;
                    row--;
                }
                else if(row < queries[i][0]){
                    break;
                }
            }
            answer[i] = min;
        }

        return answer;
    }

}
