package _2023113;

import java.util.Scanner;

/**
 * 2231 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class _01_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int cnum = 0;
        int ret = 0;
        boolean flag = false;
        for (int i=0 ; i<num ; i++) {
            ret = 0;
            cnum = i;
            while (true) {
                ret += cnum % 10;
                cnum = cnum / 10;
                if (cnum == 0) break;
            }
            if (ret + i == num) {
                System.out.println(i);
                flag = true;
                break ;
            }
        }
        if (!flag)
            System.out.println(0);
    }
}
