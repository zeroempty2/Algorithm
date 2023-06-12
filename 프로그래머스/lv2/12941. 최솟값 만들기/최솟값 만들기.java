import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] temp = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, (i1,i2) -> i2 - i1);
        for(int i = 0; i < A.length; i++){
          answer += A[i] * temp[i];
        }
        return answer;
    }
}