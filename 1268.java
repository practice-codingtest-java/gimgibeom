import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        int[][] arr2 = new int[n][n];
        int[] ans = new int [n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
            arr[i][4] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = 0; k < 5; k++){
                    if(arr[i][k] == arr[j][k]) {
                        ans[i]++;
                        ans[j]++;
                        break;
                    }
                }
            }
        }
        int maxVal = -1;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(ans[i] > maxVal){
                maxVal = ans[i];
                index = i+1;
            }
        }
        bw.write(index+"\n");
        bw.flush();
        bw.close();
    }
    
}
