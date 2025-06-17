import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int staridx = 0;
        int checkmod = a.charAt(12) - '0';
        int sum = 0;
        for(int i = 0; i < 12; i++){
            if(a.charAt(i) == '*'){
                staridx = i;
                continue;
            }
            int k = a.charAt(i) - '0';
            if(i%2 == 0){
                sum+=k;
            } else {
                sum+=(3*k);
            }
        }
        for(int i = 0; i < 10; i++){
            int tmp = sum;
            if(staridx%2 == 0){
                tmp += i;
            } else {
                tmp += (3*i);
            }
            if((10 - (tmp % 10)) == checkmod){
                if(tmp%10 == 0 && checkmod == 0){
                    System.out.println(i);
                    return;
                }
                System.out.println(i);
                return;
            }
        }
    }
}
