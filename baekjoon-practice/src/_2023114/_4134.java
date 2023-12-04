package _2023114;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 4134 다음 소수
 * https://www.acmicpc.net/problem/4134
 */
public class _4134 {
    public static void main(String[] args) throws IOException {

        long num = readInt();
        StringBuilder sb = new StringBuilder();
        for (long i=0 ;i<num ; i++) {
            long n = readInt();
            BigInteger b = BigInteger.valueOf(n);
            BigInteger bigInteger = b;
            if (!b.isProbablePrime(50))
                bigInteger = b.nextProbablePrime();
            sb.append(bigInteger).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    static long readInt() throws IOException {
        long sum = 0;
        boolean isNegative = false;
        while (true) {
            long input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
