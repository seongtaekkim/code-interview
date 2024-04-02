package math;

import java.io.IOException;
import java.util.Scanner;

/**
 * 11444 피보나치 수 6
 * https://www.acmicpc.net/problem/11444
 *
 * 피보나치를 행렬꼴로 만들어 풀이함
 */
public class _11444 {
    final static long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        long N = Long.parseLong(scanner.next());

        if(N == 1 || N == 0) {
            System.out.println(N);
            return;
        }

        // A^(n-1)의 [0][0] 원소를 구하면 되므로 1을 빼준다.
        N--;

        long[][] origin = {{1, 1},{1, 0}};
        long[][] A = {{1, 0},{0, 1}};	// 단위행렬(I)로 초기화

        /*
         * origin 행렬은 이전 loop에서 제곱값을 갖고있는 행렬이고,
         * A는 지수가 홀 수 일 때, 이전 loop에서 얻은 제곱 행렬인 origin과
         * 현재 A 행렬을 곱해주는 방식으로 간다.
         *
         * (재귀 역순)
         *
         * ex)
         * A^11 과정일 떄,
         *
         * N = 11 (N % 2 == 1) -> I * A^1 = A^1 (result)
         *                     -> A^1 * A^1 = A^2 (origin)
         *
         * N = 5  (N % 2 == 1) -> A^1 * A^2 = A^3 (result)
         *                     -> A^2 * A^2 = A^4 (origin)
         *
         * N = 2  (N % 2 == 0) -> A^4 * A^4 = A^8 (origin)
         *
         * N = 1  (N % 2 == 1) -> A^3 * A^8 = A^11 (result)
         *                     -> A^8 * A^8 = A^16 (origin)
         */
        while(N > 0) {

            // 지수가 홀수라면 origin 배열을 한 번 더 곱해준다.
            if(N % 2 == 1) {	// N % 2 == 1 는 (N & 1L) != 0L 와 같다.
                A = multiply(A, origin);
            }
            origin = multiply(origin, origin);

            N /= 2;
        }

        System.out.println(A[0][0]);

    }

    // 행렬 곱
    public static long[][] multiply(long[][] o1, long[][] o2) {

        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        return ret;
    }
}
