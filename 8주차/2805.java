import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 0;
        int hi = 1_000_000_000;
        int ans = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (v[i] > mid) {
                    sum += v[i] - mid;
                }
            }

            if (sum >= m) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}