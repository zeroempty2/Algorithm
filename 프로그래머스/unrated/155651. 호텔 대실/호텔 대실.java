class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int arr[] = new int[1440];

        for(String[] time : book_time){
            int start = change(time[0]);
            int end = Math.min(1439, change(time[1]) + 10);
            for(int i = start; i < end; i++){
                arr[i]++;
            }
        }

        for(int count : arr){
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
    
    public int change(String time){
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]); 
    }
}