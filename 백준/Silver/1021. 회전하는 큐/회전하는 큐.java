import java.util.LinkedList;
import java.util.Deque;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    static int findPosition(Deque<Integer> deque, int target) {
        Object[] array = deque.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    static void rotateLeft(Deque<Integer> deque) {
        int front = deque.pollFirst();
        deque.addLast(front);
    }
    
    static void rotateRight(Deque<Integer> deque) {
        int rear = deque.pollLast();
        deque.addFirst(rear);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        
        String[] secondLine = br.readLine().split(" ");
        
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        
        int totalOperations = 0;
        
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(secondLine[i]);
            
            int position = findPosition(deque, target);
            
            int leftRotations = position;
            int rightRotations = deque.size() - position;
            
            if (leftRotations <= rightRotations) {
                for (int j = 0; j < leftRotations; j++) {
                    rotateLeft(deque);
                }
                totalOperations += leftRotations;
            } else {
                for (int j = 0; j < rightRotations; j++) {
                    rotateRight(deque);
                }
                totalOperations += rightRotations;
            }
            
            deque.pollFirst();
        }
        
        System.out.println(totalOperations);
    }
}