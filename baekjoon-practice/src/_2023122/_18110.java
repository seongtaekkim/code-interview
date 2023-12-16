package _2023122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 18110 solved.ac
 * https://www.acmicpc.net/problem/18110
 */
public class _18110 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            for (int i=0 ; i<num ; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int edge = (int)Math.round(num * 0.15);
            Arrays.sort(arr);
            int sum = 0;
            for (int i=edge; i<num-edge ; i++)
                sum += arr[i];
            float ret = (float) sum /(num-edge*2);
            System.out.println(Math.round(ret));
        } catch (IOException e) {
            // TODO
        }
    }
}
