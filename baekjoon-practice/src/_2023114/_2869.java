package _2023114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2869 달팽이는 올라가고 싶다
 * https://www.acmicpc.net/problem/2869
 */
public class _2869 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] line = br.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int V = Integer.parseInt(line[2]);
            int x = V / (A-B);
            int ret = 0;
            while (true) {
                ret = A * x - B * x;
                if (ret >= V) {
                    while  (A * x - B * x - A + 2*B >= V) // 하루 빼고 저녁 빼고.
                        x--;
                    break ;
                }
                x++;
            }
            System.out.println(x);
        } catch (IOException e) {
            // TODO
        }
    }
}
