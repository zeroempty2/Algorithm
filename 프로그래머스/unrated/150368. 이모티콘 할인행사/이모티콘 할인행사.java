class Solution {
    int[] rate = {90, 80, 70, 60};
    int emoticonPlus = 0;
    int sale = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(emoticons, users, 0, new int[emoticons.length]);
        return new int[]{emoticonPlus, sale};
    }

    void dfs(int[] emoticons, int[][] users, int cnt, int[] rates){
        if(cnt == emoticons.length){
            int thisPlus = 0;
            int total = 0;
    
            for (int[] user : users) {
                int expense = 0;
                int rate = user[0];
                int price = user[1];
                for (int i = 0; i < rates.length; i++) {
                    if (100 - rates[i] >= rate) {
                        expense += emoticons[i] * rates[i] / 100;
                    }
                    if (expense >= price) { //소비가 price이상이면 플러스 가입
                        thisPlus += 1;
                        expense = 0;
                        break;
                    }
                }
                total += expense; // price이하면 총소비 증가
            }
    
            if (thisPlus > emoticonPlus) {  // 이번 연산의 plus가입자가 더 많으면 값 변경
                emoticonPlus = thisPlus;
                sale = total;
            } else if (thisPlus == emoticonPlus) { // 이번 연산의 plus가입자가 같고 소비금액이 더 많으면 값 변경
                sale = Math.max(total, sale);
            }
            return;
        }

        for (int r : rate) {
            rates[cnt] = r;
            dfs(emoticons, users, cnt + 1, rates);
        }

    }
}