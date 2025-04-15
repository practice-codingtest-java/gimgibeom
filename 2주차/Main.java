import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        //1,2,3,4... 숫자의 합이 100을 넘지 않는 경우
        int a = 1;
        int i = 2;
        while(a+i <= 100){
            a+=i;
            i++;
        }
        System.out.println(i-1);
    }
}