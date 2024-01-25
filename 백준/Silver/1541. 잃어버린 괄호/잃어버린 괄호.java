import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class Main {
    static int 합 = 0;
    public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);

    String 패턴 = "^[0-9]*$"; 
    String 식 = sc.nextLine();
    String[] 배열 = 식.split("-");

    
    for(int 인덱스 = 0; 인덱스 < 배열.length; 인덱스++){
        String 숫자 = 배열[인덱스];
        if(인덱스 == 0 && Pattern.matches(패턴, 숫자)) 합 = Integer.parseInt(숫자);
        else if(!Pattern.matches(패턴, 숫자)){
            int 계산합 = 합계산(숫자);
            if(합 == 0) 합 = 계산합;
            else 합 -= 계산합;
        }
        else 합 -= Integer.parseInt(숫자); 
    }

    System.out.println(합);
}
    static int 합계산(String 식){
        int 합 = 0;
        String[] 합배열 = 식.split("[+]");
        for(String 숫자 : 합배열){
            합 += Integer.parseInt(숫자);
        }
        return 합;
    }
} 