package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2023 신기한 소수
 * https://www.acmicpc.net/problem/2023
 *
 *
 * 1. 소수조건1) 가장 앞 숫자가 1,3,5,7 중 하나
 * 2. 소수조건2) 가장 뒤 숫자가 1,3,7,9 중 하나 (10 이상일 때)
 *
 * 결과 숫자가 검사할 숫자보다 압도적으로 적기 때문에
 * 모든 숫자를 소수검사하지 말고
 * 1의자리부터 백트래킹으로 만들어 나가는게 효율적이다.
 */
public class _2023 {

    static int N;
    private static boolean findSosu(int number) {
        if (number == 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            N = Integer.parseInt(br.readLine());
            check(N ,2);
            check(N,3);
            check(N,5);
            check(N,7);
            System.out.println(sb);
        } catch (IOException e) {
            //TODO
        }
    }
    static StringBuilder sb = new StringBuilder();

    private static void check(int n, int update) {
        if (n == String.valueOf(update).length()) {
            System.out.println(update);
            return;
        }
        int[] lastN = new int[] {1,3,7,9};
        for (int i=0; i<lastN.length ; i++) {
            int update2 = update * 10 + lastN[i];
            if (findSosu(update2)) {
                check(n, update2);
                update = update2/10;
            }
        }
    }

}
