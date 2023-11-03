import java.util.*;

class Solution {
    int sum;
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        char[][] mapsArr = new char[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                mapsArr[i][j] = maps[i].charAt(j);
            }
        }

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                sum = 0;
                if(mapsArr[i][j] != 'X'){
                    check(mapsArr, i, j);
                    list.add(sum);
                } 
            }
        }
        
        if(list.size() == 0) return new int[]{-1};

        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++) answer[i] = list.get(i);

        Arrays.sort(answer);

        return answer;
    }

    void check(char[][] arr, int i, int j){
        sum += Character.getNumericValue(arr[i][j]);
        arr[i][j] = 'X';
        if(i+1 != arr.length && arr[i+1][j] != 'X') check(arr, i+1, j);
        if(j+1 != arr[0].length && arr[i][j+1] != 'X') check(arr, i, j+1);
        if(i != 0 && arr[i-1][j] != 'X') check(arr, i-1, j);
        if(j != 0 && arr[i][j-1] != 'X') check(arr, i, j-1);
    }
}