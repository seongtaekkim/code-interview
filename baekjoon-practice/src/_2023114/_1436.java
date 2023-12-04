package _2023114;

import java.util.Scanner;

/**
 * 1436 영화감독 숌
 * https://www.acmicpc.net/problem/1436
 */
public class _1436 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int num = 666;
        int count = 1;

        while(count != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
