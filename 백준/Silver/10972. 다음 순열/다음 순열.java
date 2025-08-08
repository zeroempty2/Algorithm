import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if (nextPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        // 마지막 순열인 경우
        if (i <= 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }


        swap(arr, i - 1, j);


        int k = arr.length - 1;
        while (i < k) {
            swap(arr, i, k);
            i++;
            k--;
        }

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
