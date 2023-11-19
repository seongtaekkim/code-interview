package _2023112;

import java.io.IOException;

/**
 * 2839 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class _27_2839 {

    private final static int KG5 = 5;
    private final static int KG3 = 3;

    public static void main(String[] args) throws IOException {
        int kg = readInt();
        int numOf5 = 0;
        int numOf3 = 0;
        while (true) {
            if (numOf5 * KG5 > kg) break;
            numOf5++;
        }
        while (true) {
            if (numOf5 > 0) numOf5--;
            while (true) {
                if (numOf5 * KG5 + numOf3 * KG3 == kg) {
                    System.out.println(numOf5 + numOf3);
                    return;
                }
                if (numOf5 * KG5 + numOf3 * KG3 > kg)
                    break ;
                numOf3++;
            }
            if (numOf3 * KG3 > kg) {
                System.out.println(-1);
                break;
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
