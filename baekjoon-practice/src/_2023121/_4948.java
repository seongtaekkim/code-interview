package _2023121;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * 4948 베르트랑 공준
 * https://www.acmicpc.net/problem/4948
 */
public class _4948 {


    // 123456 * 2 + 1
    public static boolean[] prime = new boolean[246913];

    public static void main(String[] args) throws IOException {

        get_prime();
        while (true) {
            int n = readInt();
            if(n == 0) break;

            int count = 0;
            for(int i = n + 1; i <= 2 * n; i++)
                if(!prime[i]) count++;
            System.out.println(count);
        }
    }
    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
