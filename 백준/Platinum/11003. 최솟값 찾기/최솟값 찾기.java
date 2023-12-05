import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int numberLength = Integer.valueOf(st.nextToken());
    int readLength = Integer.valueOf(st.nextToken());

    Deque<Node> dq = new LinkedList<>();

    st = new StringTokenizer(bf.readLine());

    int index = 0;
    while(index < numberLength){
      Node node = new Node(Integer.valueOf(st.nextToken()),index);
      index++;
      while(!dq.isEmpty() && dq.getLast().value > node.value){
        dq.removeLast();
      }
      dq.add(node);
      if (dq.getFirst().index < index - readLength){
        dq.removeFirst();
      }
      bw.write(dq.getFirst().value + " ");
    }
    bw.flush();
    bw.close();
}
}

class Node{
  int value;
  int index;

  public Node(int value, int index) {
      this.value = value;
      this.index = index;
  }
}
