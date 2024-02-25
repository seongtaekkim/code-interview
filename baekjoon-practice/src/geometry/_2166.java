package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2166 다각형의 면적
 * https://www.acmicpc.net/problem/2166
 *
 * 공식 대입해서 품
 * https://ko.wikihow.com/%EB%8B%A4%EA%B0%81%ED%98%95-%EB%84%93%EC%9D%B4-%EA%B5%AC%ED%95%98%EA%B8%B0
 5
 -100000 100000
 -100000 -100000
 100000 -100000
 100000 99999
 99999 100000

 */
public class _2166 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            long[] x = new long[N+1];
            long[] y = new long[N+1];
            for (int i=0; i<N ; i++) {
                String[] in = br.readLine().split(" ");
                x[i] = Integer.parseInt(in[0]);
                y[i] = Integer.parseInt(in[1]);
            }
            double retx = 0.0, rety = 0.0;

            x[N] = x[0];
            y[N] = y[0];
            for (int i=0; i<N ; i++) {
                retx += (x[i] * y[i+1]) - (y[i] * x[i+1]);
            }
            System.out.printf("%.1f",Math.abs(retx)/2.0);

        } catch (IOException e) {
            // TODO
        }
    }
}
