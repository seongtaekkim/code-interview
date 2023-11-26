package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2798 블랙잭
 * https://www.acmicpc.net/problem/2798
 */
public class _05_2798 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String[] init = br.readLine().split(" ");
            int num = Integer.parseInt(init[0]);
            int black = Integer.parseInt(init[1]);
            int max=0;
            String[] cards = br.readLine().split(" ");
            int[] arr = new int[num];
            for (int i=0 ; i< cards.length ; i++)
                arr[i] = Integer.parseInt(cards[i]);

            for (int i=0 ; i<cards.length-2 ; i++) {
                for (int j=i+1 ; j<cards.length-1 ; j++) {
                    for (int k=j+1 ; k<cards.length ; k++) {
                        int tmp = arr[i] + arr[j] + arr[k];
                        if (black >= tmp) {
                            if (max < tmp)
                                max = tmp;
                        }
                    }
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            // TODO
        }
    }


}
