class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^0-9a-z-_.]", "");

        answer = answer.replaceAll("\\.{2,}", ".");

        answer = answer.replaceAll("^[.]|[.]$", "");
        
        if (answer.equals("")) {
            answer = "a";
        }
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        
        answer = answer.replaceAll("[.]$", "");
        
        if (answer.length() <= 2) {
            char ch = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += ch;
            }
        }
        return answer;
    }
}