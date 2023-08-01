class Solution {
    public String solution(int a, int b) {
        int[] cal = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        String[] days = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int day = b;
        for(int i = 0; i < a - 1; i++){
            day += cal[i];
        }
        return days[((day -1) % 7)];
    }
}