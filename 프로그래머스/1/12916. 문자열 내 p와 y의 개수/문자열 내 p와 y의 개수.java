class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for(String temp : s.split("")){
            if(temp.equals("p") || temp.equals("P")) p++;
            if(temp.equals("y") || temp.equals("Y")) y++;
        }
        return p == y ? true : false;
    }
}