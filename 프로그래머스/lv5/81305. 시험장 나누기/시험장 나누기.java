import java.util.Arrays;

class Solution {
    int myK = 1;
    int[] N;
    int[][] links;
    public int solution(int k, int[] num, int[][] links) {
        int root = 0;
        this.links = links;
        N = num;
        int[] fR = new int[num.length];

        //links[i] == 노드 번호
        //links[i][0] == 노드의 왼쪽자식
        //links[i][1] == 노드의 오른쪽 자식
        Arrays.fill(fR, -1);

        // 루트 노드, 자식 노드 구분
        for(int i = 0; i < num.length; i++){ 
            if(links[i][0] != -1) fR[links[i][0]] = i;
            if(links[i][1] != -1) fR[links[i][1]] = i;
        }

        // 루트 노드 탐색
        for(int i = 0; i < num.length; i++){
            if(fR[i] == -1){
                root = i;
                break;
            }
        }

        int start = 0;
        int end = 0;

        // 모든 노드의 인원 수를 합산하여 start와 end 설정
        for(int i = 0; i < num.length; i++){
            end += num[i];
            start = Math.max(start, num[i]);
        }

        // 이진 탐색
        while(start < end){
            int middle = (start + end)/2;
            treeSearch(root, middle);
            if(myK > k){
                start = middle + 1;
            }else{
                end = middle;
            }
            myK = 1;
        }

        return start;
    }

    public int treeSearch(int index, int bound){

        // 자식노드가 없을때 자신이 가진 인원수 반환
        if(links[index][0] == -1 && links[index][1] == -1) return N[index]; 

        // 왼쪽이나 오른쪽 자식노드가 존재할때, 왼쪽 자식 노드와 오른쪽 자식 노드에서의 탐색 결과를 계산
        int left = links[index][0] == -1 ? 0 : treeSearch(links[index][0], bound);  
        int right = links[index][1]== -1 ? 0 : treeSearch(links[index][1], bound);

        int a = left + right + N[index];

        // 탐색 결과가 bound의 절반 이하인 경우 반환
        if(a <= bound) return a;
        
        if(left==0 || right==0){
            myK++;
            return N[index];
        }

        // 왼쪽과 오른쪽 중 어떤 자식 노드를 선택할지 결정하고 myK 증가
        if(left < right){
            myK++;
            if(left + N[index] > bound){
                myK++;
                return N[index];
            }
            return N[index]+left;
        }
        else{
            myK++;
            if(right + N[index] > bound){
                myK++;
                return N[index];
            }
            return N[index]+right;
        }
    }
}