package _2023114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11050 이항계수
 * https://www.acmicpc.net/problem/11050
 */
public class _11050 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);
            int ret = 1;
            int mod = 1;
            for (int i=0 ; i<k ; i++) {
                ret = ret * n;
                n--;
            }
            while (k>0) {
                mod = mod * k;
                k--;
            }
            System.out.println(ret/mod);
        } catch (IOException e) {
            // TODO
        }
    }
}
