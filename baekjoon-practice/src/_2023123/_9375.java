package _2023123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 9375 패션왕 신해빈
 * https://www.acmicpc.net/problem/9375
 */
public class _9375 {

    static Map<String, Integer> origin = new HashMap<>();
    static Object[] keySet;

    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            for (int i=0 ; i<N ; i++) {
                int K = Integer.parseInt(br.readLine());
                origin = new HashMap<>();
                for (int j=0; j<K ; j++) {
                    String[] line = br.readLine().split(" ");
                    if (origin.get(line[1]) != null)
                        origin.replace(line[1], origin.get(line[1])+1);
                    else
                        origin.put(line[1], 1);
                }
                keySet = origin.keySet().toArray();

                int ret = 1;

                for (Integer integer : origin.values()) {
                    ret = ret * (integer + 1);
                }
                System.out.println(ret-1);
            }

        } catch (IOException e) {
            // TODO
        }
    }

}
