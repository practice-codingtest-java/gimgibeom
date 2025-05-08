import java.util.*;
import java.io.*;

public class Main {
    static int m,n,o,p,q,r,s,t,u,v,w;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int[] arr = new int[m*n*o*p*q*r*s*t*u*v*w];
        int[] visited = new int[m*n*o*p*q*r*s*t*u*v*w];
        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> cnts = new ArrayDeque<>();
        for(int i = 0; i < n*o*p*q*r*s*t*u*v*w; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i*m + j] = Integer.parseInt(st.nextToken());
                if(arr[i*m + j] == 1){
                    queue.add(i*m+j);
                    cnts.add(0);
                    visited[i*m+j] = 1;
                } else if(arr[i*m+j] == -1){
                    visited[i*m+j] = 1;
                }
            }
        }
        int[] dx = {1,-1,m,-m,m*n,-m*n,m*n*o,-m*n*o,m*n*o*p,-m*n*o*p,m*n*o*p*q,-m*n*o*p*q,m*n*o*p*q*r,
            -m*n*o*p*q*r,m*n*o*p*q*r*s,-m*n*o*p*q*r*s,m*n*o*p*q*r*s*t,-m*n*o*p*q*r*s*t,m*n*o*p*q*r*s*t*u,
            -m*n*o*p*q*r*s*t*u,m*n*o*p*q*r*s*t*u*v,-m*n*o*p*q*r*s*t*u*v};
        int maxCnt = -1;
        while(!queue.isEmpty()){
            int px = queue.poll();
            int pcnt = cnts.poll();
            maxCnt = pcnt;
            // System.out.println(px + ":px");
            for(int i = 0; i < 22; i++){
                int nx = px+dx[i];
                // System.out.print(nx + "nx");
                if(nx < 0 || nx >= m*n*o*p*q*r*s*t*u*v*w){
                    // System.out.println(" out of range");
                    continue;
                }
                if(visited[nx] == 1) {
                    // System.out.println(" visited");
                    continue;
                }
                // System.out.println("i%2 " + i%2);
                if(i/2 == 0){
                    if(nx/m == px/m) {
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                } 
                if(i/2 == 1){
                    if(nx/(n*m) == px/(n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                } 
                if(i/2 == 2){
                    if(nx/(o*n*m) == px/(o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 3){
                    if(nx/(p*o*n*m) == px/(p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 4){
                    if(nx/(q*p*o*n*m) == px/(q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 5){
                    if(nx/(r*q*p*o*n*m) == px/(r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 6){
                    if(nx/(s*r*q*p*o*n*m) == px/(s*r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 7){
                    if(nx/(t*s*r*q*p*o*n*m) == px/(t*s*r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 8){
                    if(nx/(u*t*s*r*q*p*o*n*m) == px/(u*t*s*r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 9){
                    if(nx/(v*u*t*s*r*q*p*o*n*m) == px/(v*u*t*s*r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
                if(i/2 == 10){
                    if(nx/((w*v*u*t*s*r*q*p*o*n*m)) == px/(w*v*u*t*s*r*q*p*o*n*m)){
                        queue.add(nx);
                        cnts.add(pcnt+1);
                        visited[nx] = 1;
                    }
                }
            }
        }
        // System.out.println();
        // for(int i = 0; i < n*o*p*q*r*s*t*u*v*w; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(arr[i*m+j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for(int i = 0; i < n*o*p*q*r*s*t*u*v*w; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(visited[i*m+j] + " ");
        //     }
        //     System.out.println();
        // }
        for(int i = 0; i < m*n*o*p*q*r*s*t*u*v*w; i++){
            if(visited[i] == 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(maxCnt);
    }
}
