class Solution {
      public int solution(int n, int m, int[] section) {
    int answer = 0;
    int roller = 1;

    for (int j : section) {
      if (roller <= j) {
        roller = j + m;
        answer++;
      }
    }

    return answer;
  }
}