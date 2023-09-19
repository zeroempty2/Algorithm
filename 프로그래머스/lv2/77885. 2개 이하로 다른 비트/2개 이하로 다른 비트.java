
class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1L;
                continue;
            }

            String binary = Long.toBinaryString(numbers[i]);
     
            if (!binary.contains("0")) {
                binary = 0 + binary;
                binary = String.valueOf(binary.charAt(1)) + binary.charAt(0) + binary.substring(2);
            }else{
                int x = binary.lastIndexOf("0");
                binary = binary.substring(0, x) + "10" + binary.substring(x + 2);
            }

            answer[i] = cal(binary);

        }
            
        return answer;
    
        }

        long cal(String binary) {
            binary = new StringBuilder(binary).reverse().toString();
            long ans = 0;
            long x = 1L;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    ans += x;
                }
                x *= 2;
            }
    
            return ans;
        }
}