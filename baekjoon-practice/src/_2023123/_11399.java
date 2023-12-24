package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 11399 ATM
 * https://www.acmicpc.net/problem/11399
 */
public class _11399 {

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>(N);
            String[] line = br.readLine().split(" ");
            for (int i=0 ; i<N ; i++) {
                list.add(Integer.parseInt(line[i]));
            }
            Collections.sort(list);

            int[] accum = new int[N];
            int sum;
            sum = accum[0] = list.get(0);
            for (int i=1 ; i<N ; i++) {
                accum[i] = accum[i-1] + list.get(i);
                sum += accum[i];
            }
            System.out.println(sum);
        } catch (IOException e) {
            // TODO
        }
    }

}
