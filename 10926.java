import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuffer stringBuffer = new StringBuffer(a);
        stringBuffer.append("??!");
        System.out.println(stringBuffer.toString());
    }
}
