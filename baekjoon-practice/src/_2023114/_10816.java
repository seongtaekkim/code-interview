package _2023114;

import java.io.*;

/**
 * 10816 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
public class _10816 {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] myArr = new int[20000001];
            for (int i=0 ; i<num ; i++) {
                myArr[Integer.parseInt(line[i])+10000000]++;
            }

            int targetNum = Integer.parseInt(br.readLine());
            String[] targetLine = br.readLine().split(" ");
            int[] targetArr = new int[targetNum];
            int[] binary = new int[targetNum];

            for (int i=0 ; i<targetNum ; i++) {
                targetArr[i] = Integer.parseInt(targetLine[i]);
            }

            for (int i=0 ; i<targetNum ; i++) {
                binary[i] = myArr[targetArr[i]+10000000];
            }
            for(int i : binary)
                bw.write(i + " ");
            bw.flush();

        } catch (IOException e) {
            // TODO
        }
    }
}
