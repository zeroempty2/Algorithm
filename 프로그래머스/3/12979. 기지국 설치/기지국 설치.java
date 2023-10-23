class Solution {
    public int solution(int n, int[] stations, int w) {    
        int start = 1;
        int end = stations[0] - 1 - w > 0 ? stations[0] - 1 - w : 0;
        int answer = cal(end - start + 1, w);

        for(int i = 1; i < stations.length; i++){
            start = stations[i - 1] + w + 1;
            end =  stations[i] - w - 1;
            answer += cal(end - start + 1, w);
        }

        start = stations[stations.length - 1] + w + 1;
        end = n;

        return answer += cal(end - start + 1, w);
    }

    public int cal(int need, int w){
        w = w * 2 + 1;
        if (need <= 0) {
            return 0;
        }
        if (need % w == 0) {
            return (need / w);
        } else {
            return (need / w) + 1;
        }
    }
}