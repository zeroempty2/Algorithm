class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        boolean empty = true;
        int check = 0;
        for(char i : X.toCharArray()){
            arr[Character.getNumericValue(i)] += 1;
        }
        for(char j : Y.toCharArray()){
            if(arr[Character.getNumericValue(j)] >= 1){
                arr[Character.getNumericValue(j)] -= 1;
                arr2[Character.getNumericValue(j)] += 1;
            }
        }
       for(int k = 9; k >= 0; k--){
        if(arr2[k] > 0){
            while(arr2[k] > 0){
                answer.append(String.valueOf(k));
                check += k;
                arr2[k] -= 1;
            }
            empty = false;
        }
       }
       if(check == 0 && !empty) return "0";
       if(empty) return "-1";
        return answer.toString();
    }
}