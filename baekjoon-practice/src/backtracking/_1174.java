package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1174 줄어드는 수
 * https://www.acmicpc.net/problem/1174
 *
 * 3
 * 30
 * 31
 * 310
 * 32
 * 321
 * 3210
 */
public class _1174 {

    static int N;
    static List<Long> list;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for (long i=0 ; i<10L ; i++)
                check(i);
            Collections.sort(list);
//            list.forEach(System.out::println);
            if (N >= 1022) {
                System.out.println(-1);
            } else
                System.out.println(list.get(N-1));
        } catch (IOException e) {
            //TODO
        }
    }

    private static void check(long n) {
        if (n > 9876543210L) {
            return ;
        }
        list.add(n);
        for (long i =0; i<10 ; i++) {
            long m = n * 10 + i;
            if (n % 10 > i)
                check(m);
        }
    }


}
