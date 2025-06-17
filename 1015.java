import java.util.*;
import java.io.*;

public class Main {
    static class Num implements Comparable<Num> {
        int val;
        int idx;
        public Num(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Num num){
            return num.val - this.val;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr1[i] = tmp;
            arr2[i] = tmp;
        }
        Arrays.sort(arr2);
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr1[i] == arr2[j] && !hs.contains(j)){
                    hs.add(j);
                    System.out.print(j + " ");
                    break;
                }
            }
        }
    }
}
