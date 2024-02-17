import java.io.*;
import java.util.*;
public class Main {
    static int[] peoples;
    static int[] know;
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int people = Integer.parseInt(st.nextToken());
    int party = Integer.parseInt(st.nextToken());
    peoples = new int[people + 1];
    for(int i = 0; i < peoples.length; i++) peoples[i] = i;

    st = new StringTokenizer(bf.readLine());

    int knowTruth = Integer.parseInt(st.nextToken());
    know = new int[knowTruth];
    for(int i = 0; i < know.length; i++) know[i] = Integer.parseInt(st.nextToken());

    PartyInfo[] partyInfo = new PartyInfo[party];

    for(int i = 0; i < partyInfo.length; i++){
        st = new StringTokenizer(bf.readLine());
        int partyMember = Integer.parseInt(st.nextToken());
        int[] members = new int[partyMember];

        for(int j = 0; j < partyMember; j++){
            members[j] = Integer.parseInt(st.nextToken());
        }
        int first = members[0];
        for(int k = 1; k < partyMember; k++){
            union(first, members[k]);
        }

        partyInfo[i] = new PartyInfo(members);
    }

    int result = 0;
    for(int i = 0; i < partyInfo.length; i++){
        int cur = partyInfo[i].members[0];
        boolean isPossible = true;
        for(int j = 0; j < know.length; j++){
            if(check(cur, know[j])){
                isPossible = false;
                break;
            } 
        }
        if(isPossible) result++;
    }
   
    System.out.println(result);
}

static class PartyInfo{
    int[] members;

    public PartyInfo(int[] members){
        this.members = members;
    }
}
static void union(int a, int b){
    a = find(a);
    b = find(b);
    if(a != b) peoples[b] = a;
}

static int find(int a){
    if(a == peoples[a]) return a;
    else return peoples[a] = find(peoples[a]);
}
static boolean check(int a, int b){
    a = find(a);
    b = find(b);
    return a == b;
}

}
