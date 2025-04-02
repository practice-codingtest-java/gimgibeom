import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int[] nums = {0,0,0,0,0,0,0,0,0,0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        for(int i = 0; i < a.length(); i++) {
            int tmp = a.charAt(i) - '0';
            if(tmp == 6 || tmp == 9){
                if(nums[6] > nums[9]) nums[9]++;
                else nums[6]++;
            } else{
                nums[tmp]++;
            }
        }
        Arrays.sort(nums);
        System.out.println(nums[9]);
    }
}
