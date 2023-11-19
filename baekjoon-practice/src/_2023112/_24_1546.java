package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1546 평균
 * https://www.acmicpc.net/problem/1546
 */
public class _24_1546 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            String[] subs = br.readLine().split(" ");
            int sum = 0;
            int tmp;
            int max = 0;
            for (int i=0; i<num ; i++) {
                tmp = Integer.parseInt(subs[i]);
                if (max < tmp)
                    max = tmp;
                sum += tmp;
            }
            System.out.println(((double)sum/max)*100/num);

        } catch (IOException e) {
            //TODO
        }
    }
}
