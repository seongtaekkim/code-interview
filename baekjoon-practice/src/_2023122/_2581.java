package _2023122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 2581 소수
 * https://www.acmicpc.net/problem/2581
 */
public class _2581 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int M = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            BigInteger bi = BigInteger.valueOf(M);
            int init = -1;
            int sum = 0;
            if (bi.isProbablePrime(bi.intValue())) {
                sum += bi.intValue();
                init = sum;
            }

            while (true) {
                bi = bi.nextProbablePrime();
                if (bi.intValue() > N) break ;
                if (init == -1)
                    init = bi.intValue();
                sum += bi.intValue();
            }
            if (init != -1)
                System.out.println(sum);
            System.out.println(init);
        } catch (IOException e) {
            // TODO
        }
    }
}
