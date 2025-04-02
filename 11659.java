import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        int n,m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] cell = new int[n+1];
        cell[0] = 0;
        for(int i = 1; i <= n; i++){
            cell[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++){
            cell[i] += cell[i-1];
        }
        while (m-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(cell[b]-cell[a-1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
