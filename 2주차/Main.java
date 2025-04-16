import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < 10; i++){
            pq.add(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(pq.poll());
        }
    }
}