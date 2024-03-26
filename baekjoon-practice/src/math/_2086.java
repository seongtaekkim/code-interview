package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 2086 피보나치 수의 합
 * https://www.acmicpc.net/problem/2086
 *
 *
 * 참조
 * https://ko.wikipedia.org/wiki/%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98_%EC%88%98
 * https://www.youtube.com/watch?v=_zezT5g_33Q
 *
 */
public class _2086 {
    static long MOD = 1_000_000_000;

    static HashMap<Long, Long> hm;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().split(" ");
            long a = Long.parseLong(in[0]);
            long b = Long.parseLong(in[1]);

            hm = new HashMap<>();
            hm.put((long) 1, (long) 1);
            hm.put((long) 2, (long) 1);
            hm.put((long) 3, (long) 2);

            long f1 = fibo(a + 1);
            long f2 = fibo(b + 2);
            System.out.println((f2 - f1 + MOD) % MOD);
        }
    }
    static long fibo(long idx) {
        if (hm.containsKey(idx)) {
            return hm.get(idx);
        } else if ((idx & 1) == 0) {
            long nIdx = idx / 2;
            long f1 = fibo(nIdx - 1);
            long f2 = fibo(nIdx);
            long tf = ((2 * f1) + f2) * f2;

            tf = tf % MOD;
            hm.put(idx, tf);

            return tf;
        } else {
            long nIdx = (idx + 1) / 2;
            long f1 = fibo(nIdx);
            long f2 = fibo(nIdx - 1);
            long tf = (f1 * f1) + (f2 * f2);
            tf = tf % MOD;

            tf = tf % MOD;
            hm.put(idx, tf);

            return tf;
        }
    }
}
