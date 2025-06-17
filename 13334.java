import java.util.*;
import java.io.*;

public class Main {
    static class Rail implements Comparable<Rail>{
        int start;
        int end;
        public Rail(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Rail r){
            if(this.end == r.end){
                return this.start - r.start;
            }
            return this.end - r.end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Rail> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start > end){
                pq.add(new Rail(end,start));
            } else {
                pq.add(new Rail(start, end));
            }
        }
        
        List<Rail> rails = new ArrayList<>();
        for(int i = 0; i < n; i++){
            rails.add(pq.poll());
        }
        int l = Integer.parseInt(br.readLine());
        int s = -1000000000;
        int e = s + l;
        int ans = 0;
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            Rail cur = rails.get(i);
            if(cur.end -  cur.start > l) continue;
            while(!pq2.isEmpty() && pq2.peek() < cur.end - l){
                pq2.poll();
            }
            pq2.add(cur.start);
            ans = Math.max(ans, pq2.size());
        }
        System.out.println(ans);
    }
}
