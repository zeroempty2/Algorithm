    import java.util.HashMap;

    class Solution {
        public String solution(String[] survey, int[] choices) {
            StringBuilder answer = new StringBuilder();
            int[][] score = new int[8][2];
            String[] defaultArr = new String[]{"R","C","J","A"};
            HashMap<String,Integer> indicators = new HashMap<>();
            HashMap<Integer,int[]> choiceMap = new HashMap<>();

            indicators.put("RT",0);
            indicators.put("TR",1);
            indicators.put("CF",2);
            indicators.put("FC",3);
            indicators.put("JM",4);
            indicators.put("MJ",5);
            indicators.put("AN",6);
            indicators.put("NA",7);
            choiceMap.put(1, new int[]{0,3});
            choiceMap.put(2, new int[]{0,2});
            choiceMap.put(3, new int[]{0,1});
            choiceMap.put(4, new int[]{0,0});
            choiceMap.put(5, new int[]{1,1});
            choiceMap.put(6, new int[]{1,2});
            choiceMap.put(7, new int[]{1,3});

            for(int i = 0; i < survey.length; i++){
                int indicate = indicators.get(survey[i]);
                int[] choice = choiceMap.get(choices[i]);
                score[indicate][choice[0]] += choice[1];
            }

            for(int j = 0; j < score.length; j++){
                int first = 0;
                int second = 0;
                first += score[j][0];
                first += score[j+1][1];
                second += score[j][1];
                second += score[j+1][0];
                if(j == 0 && first != second){
                    defaultArr[0] = second > first ? "T" : "R";
                }
                if(j == 2 && first != second){
                    defaultArr[1] = second > first ? "F" : "C";
                }
                if(j == 4 && first != second){
                    defaultArr[2] = second > first ? "M" : "J";
                }
                if(j == 6 && first != second){
                    defaultArr[3] = second > first ? "N" : "A";
                }
                j++;
            }

            for(int k = 0; k < defaultArr.length; k++){
                answer.append(defaultArr[k]);
            }

            return answer.toString();
        }
    }