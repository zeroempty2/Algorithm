import java.util.HashMap;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashMap<String,Integer> babblingMap = new HashMap<>();
        babblingMap.put("aya",1);
        babblingMap.put("ye",2);
        babblingMap.put("woo",3);
        babblingMap.put("ma",4);
        int check = 0;
        int key = 0;
        int point = 0;
        int checkPoint = 0;
        while(check < babbling.length){
            for(int i = 0; i < babbling[check].length(); i++){
                if(babbling[check].charAt(i) == 'a' && i+3 <= babbling[check].length()){
                    if(babblingMap.containsKey(babbling[check].substring(i, i+3))){
                        if(key != babblingMap.get(babbling[check].substring(i, i+3))){
                            point++;
                            key = babblingMap.get(babbling[check].substring(i, i+3));
                            i += 2;
                        }
                    } 
                }
                else if(babbling[check].charAt(i) == 'y' && i+2 <= babbling[check].length()){
                    if(babblingMap.containsKey(babbling[check].substring(i, i+2))){
                        if(key != babblingMap.get(babbling[check].substring(i, i+2))){
                            point++;
                            key = babblingMap.get(babbling[check].substring(i, i+2));
                            i += 1;
                        }
                    } 
                }
                else if(babbling[check].charAt(i) == 'w' && i+3 <= babbling[check].length()){
                    if(babblingMap.containsKey(babbling[check].substring(i, i+3))){
                        if(key != babblingMap.get(babbling[check].substring(i, i+3))){
                            point++;
                            key = babblingMap.get(babbling[check].substring(i, i+3));
                            i += 2;
                        }
                    } 
                }
                else if(babbling[check].charAt(i) == 'm' && i+2 <= babbling[check].length()){
                    if(babblingMap.containsKey(babbling[check].substring(i, i+2))){
                        if(key != babblingMap.get(babbling[check].substring(i, i+2))){
                            point++;
                            key = babblingMap.get(babbling[check].substring(i, i+2));
                            i += 1;
                        }
                    } 
                }
               checkPoint++;          
            }
            if(checkPoint == point) answer++;
            checkPoint = 0;
            point = 0;
            key = 0;
            check++;
        }
        return answer;
    }
}