class Solution {
    int[][] array;
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        array = arr;

        comp(0,0,arr.length);
 
        return answer;
    }
    public void comp(int row, int col, int length){
        int value = array[row][col];
        boolean check = true;
        for(int i = row; i < row + length; i++){
            for(int k = col; k < col + length; k++){
                check &= array[i][k] == value;
                if(!check) break;
                }
            }
        if(check){
             answer[value]++;
        }else{
            length /= 2;
            comp(row, col, length);
            comp(row + length, col, length);
            comp(row, col + length , length);
            comp(row + length, col + length, length);
        }
        }
    }