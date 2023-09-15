class Solution {
    public String solution(String number, int k) {
        char[] arr = new char[number.length() - k];
        char[] numberArr = number.toCharArray();
        int range = number.length() - k;
        int index = 0;
        int save = 0;
        while(save < numberArr.length){
            if(index >= arr.length) break;
            for(int i = save; i < numberArr.length; i++){
                if(number.length() - i + 1 <= range) break;
                if(numberArr[i] > arr[index]){
                    arr[index] = numberArr[i];
                    save = i + 1;
                }
            }
            index++;
            range--;
        }
        return String.valueOf(arr);
    }
}