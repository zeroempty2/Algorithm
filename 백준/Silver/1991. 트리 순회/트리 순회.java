import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split(" ");
            char parent = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            // 부모 노드가 없으면 새로 생성
            tree.putIfAbsent(parent, new Node(parent));

            // 왼쪽 자식 연결
            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(parent).left = tree.get(left);
            }

            // 오른쪽 자식 연결
            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(parent).right = tree.get(right);
            }
        }
  

        Node root = tree.get('A'); 
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        }
        static class Node {
            char data;
            Node left;
            Node right;
        
            public Node(char data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        //전위 순회
        public static void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.data); // 루트
            preOrder(node.left);         // 왼쪽 자식
            preOrder(node.right);        // 오른쪽 자식
        }
    
        // 중위 순회
        public static void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);          // 왼쪽 자식
            System.out.print(node.data); // 루트
            inOrder(node.right);         // 오른쪽 자식
        }
    
        // 후위 순회
        public static void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);        // 왼쪽 자식
            postOrder(node.right);       // 오른쪽 자식
            System.out.print(node.data); // 루트
        }
    }

