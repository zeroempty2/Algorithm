class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow; // 모든 타일의 개수
        for(int i = 3; ; i++){
            if(size % i == 0){ // i값이 한변의 길이가 될 수 있다면
                int div = size / i; // 나머지 변의 길이
                if((i-2) * (div - 2) == yellow){ // 테두리 부분을 뺀 영역이 yellow와 같다면 정답
                    answer[0] = div;
                    answer[1] = i;
                    break;
                }
                else continue;
            }
        }
        return answer;
    }
}