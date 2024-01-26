package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1038 감소하는 수
 * https://www.acmicpc.net/problem/1038
 *
 *
 * 0~9 로 시작하는 감소하는 숫자를 9876543210 보다 작은 조건으로 트래킹한다.
 *
 * 0
 * 1 10
 * 2 20 21 210
 * 3 30 31 310 32 321 3210
 * 4 40 41 410 42 420 421 4210 43 430 431 4310 432 4320 4321 43210
 */
public class _1038 {
    static List<Long> list;
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();


            for (long i=0L ; i< 10L ; i++) {
                cal(i);
            }
            Collections.sort(list);
            if (N >= 1023)
                System.out.println(-1);
            else
            System.out.println(list.get(N));
//            list.forEach(System.out::println);


        } catch (IOException e) {
            // TODO
        }
    }

    static void cal(long num) {
        if (num > 9876543210L) {
            return ;
        }
        list.add(num);
        for (int i = 0 ; i<10 ; i++) {
            if (num % 10 > i) {
                cal((num * 10) + (long)i);
            }
        }
    }
}
