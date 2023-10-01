class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        for(int i = 2; i <= arrayA[0]; i++){
            boolean pass = true;
            for(int A : arrayA){
                if(A % i != 0){
                    pass = false;
                    break;
                }
            }
            if(pass){
                for(int B : arrayB){
                    if(B % i == 0){
                        pass = false;
                        break;
                    }
                }
            }
            if(pass){
                answer = Math.max(answer, i);
            }
        }

        for(int i = 2; i <= arrayB[0]; i++){
            boolean pass = true;
            for(int B : arrayB){
                if(B % i != 0){
                    pass = false;
                    break;
                }
            }
            if(pass){
                for(int A : arrayA){
                    if(A % i == 0){
                        pass = false;
                        break;
                    }
                }
            }
            if(pass){
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}