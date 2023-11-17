package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 4153 직각삼각형
 * https://www.acmicpc.net/problem/4153
 *
 * read 학습
 *     static int readInt() throws IOException {
 *         int sum = 0;
 *         boolean isNegative = false;
 *         while (true) {
 *             int input = System.in.read();
 *             if (input == '\n' || input == ' ')
 *                 return isNegative ? sum * -1 : sum;
 *             else if (input == '-')
 *                 isNegative = true;
 *             else
 *                 sum = (sum * 10) + input - '0';
 *         }
 *     }
 */
public class _21_4153 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String read = null;
            while ((read = br.readLine()) != null) {
                if ("0 0 0".equals(read)) break ;

                String[] lines = read.split(" ");
                int a = Integer.parseInt(lines[0]);
                int b = Integer.parseInt(lines[1]);
                int c = Integer.parseInt(lines[2]);

                int aa = a*a;
                int bb = b*b;
                int cc = c*c;
                if (aa + bb == cc
                    || aa + cc == bb
                    || bb + cc == aa)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

        } catch (IOException e) {
            //TODO
        }
    }
}
