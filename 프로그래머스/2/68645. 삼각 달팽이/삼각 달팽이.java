class Solution {
    int[] x = {0, 1, -1};
    int[] y = {1, 0, -1};
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        double endNum = (n + 1) * (double)n/2;
        int[] answer = new int[(int)endNum];
        int point = 0;
        int number = 1;
        int col = 0;
        int row = 0;
        while(true){
            arr[row][col] = number;
            number++;
            if(number > endNum) break;
            int xCol = col + x[point];
            int yRow = row + y[point];
            if(xCol == n || yRow == n || arr[yRow][xCol] != 0){
                point = (point + 1) % 3;
                xCol = col + x[point];
                yRow = row + y[point];
                if(xCol == n || yRow == n || arr[yRow][xCol] != 0)
                    break;
            } 
            col = xCol;
            row = yRow;
            }

        int index = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i + 1; j++){
                answer[index] = arr[i][j];
                index++;
            }
        }
        return answer;
    }
}