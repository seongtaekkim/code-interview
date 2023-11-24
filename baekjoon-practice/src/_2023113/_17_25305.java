package _2023113;

import java.io.*;

/**
 * 25305 커트라인
 * https://www.acmicpc.net/problem/25305
 */
public class _17_25305 {
    public static void main(String[] args) throws IOException {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] set = br.readLine().split(" ");
            int num = Integer.parseInt(set[0]);
            int numOfAward = Integer.parseInt(set[1]);

            String[] line = br.readLine().split(" ");
            int[] arr = new int[line.length];
            for (int i=0 ; i<line.length ; i++)
                arr[i] = Integer.parseInt(line[i]);

            int tmp = 0;
            int minIdx = 0;
            for (int i=0 ; i<arr.length-1 ; i++) {
                minIdx = i;
                for (int j=i+1 ; j<arr.length ; j++) {
                    if (arr[minIdx] < arr[j])
                        minIdx = j;
                }
                tmp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = tmp;
            }
            System.out.println(arr[numOfAward-1]);
        }
    }
}
