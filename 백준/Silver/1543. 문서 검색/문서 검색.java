import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int idx = 0;

        while (idx <= document.length() - word.length()) {
            if (document.substring(idx, idx + word.length()).equals(word)) {
                count++;
                idx += word.length(); // 중복 없이 점프
            } else {
                idx++; // 다음 문자로 한 칸 이동
            }
        }

        System.out.println(count);
    }
}
