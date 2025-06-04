import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch == '+' || ch == '-') {
                numbers.add(Integer.parseInt(str.toString()));
                str.setLength(0);
                ops.add(ch);
            } else {
                str.append(ch);
            }
        }
        numbers.add(Integer.parseInt(str.toString()));

        int ans = numbers.get(0);
        boolean minusFlag = false;

        for (int i = 0; i < ops.size(); i++) {
            if (ops.get(i) == '-') minusFlag = true;
            if (minusFlag) {
                ans -= numbers.get(i + 1);
            } else {
                ans += numbers.get(i + 1);
            }
        }

        System.out.println(ans);
    }
}
