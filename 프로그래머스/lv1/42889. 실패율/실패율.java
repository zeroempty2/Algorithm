class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failArr = new double[N];
        int idx = stages.length;
        double fail = 0;
        int stageNum = 0; 
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            if (stage != N + 1)
                answer[stage - 1] += 1;
        }
        for (int i = 0; i < N; i++) {
            int personNum = answer[i];
            failArr[i] = (double) personNum / idx;
            idx -= personNum;
            answer[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (failArr[j - 1] < failArr[j]) {
                    fail = failArr[j - 1];
                    failArr[j - 1] = failArr[j];
                    failArr[j] = fail;

                    stageNum = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = stageNum;
                }
            }
        }
        return answer;
    }
}