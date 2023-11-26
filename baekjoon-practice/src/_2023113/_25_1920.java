package _2023113;

import java.io.*;
import java.util.Arrays;

/**
 * 1920 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class _25_1920 {
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] myArr = new int[num];
            for (int i=0 ; i<num ; i++) {
                myArr[i] = Integer.parseInt(line[i]);
            }

            Arrays.sort(myArr);

            int targetNum = Integer.parseInt(br.readLine());
            String[] targetLine = br.readLine().split(" ");
            int[] targetArr = new int[targetNum];
            int[] binary = new int[targetNum];

            for (int i=0 ; i<targetNum ; i++) {
                targetArr[i] = Integer.parseInt(targetLine[i]);
            }

            for (int i=0 ; i<targetNum ; i++) {

                int low = 0;
                int high = myArr.length - 1;
                int key = targetArr[i];

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    int midVal = myArr[mid];

                    if (midVal < key)
                        low = mid + 1;
                    else if (midVal > key)
                        high = mid - 1;
                    else {
                        binary[i] = 1;
                        break;
                    }
                }
            }
            for(int i : binary)
                bw.write(i + "\n");
            bw.flush();

        } catch (IOException e) {
            // TODO
        }
    }
}
