import java.util.ArrayList;
import java.util.List;

class Solution {
        public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        char[] arr = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        List<Character> array = new ArrayList<>();
        boolean a = true;
        for(int j = 0; j < arr.length; j++){
            for(int l = 0; l < skip.length(); l++){
                if(skip.charAt(l) == arr[j]){
                    a = false;
                    break;
                } 
                a = true;
            }
            if(a){
                array.add(arr[j]);
            }
            
        }

        for(int k = 0; k < s.length(); k++){
            for(int n = 0; n < array.size(); n++){
                if(s.charAt(k) == array.get(n)){
                    if(n+index >= array.size()){
                        answer.append(array.get((n+index)%array.size()));
                        break;
                    }else{
                        answer.append(array.get(n+index));
                        break;
                    }
                    
                }
            }
        }
        return answer.toString();
    }
}