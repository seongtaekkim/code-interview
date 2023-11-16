package _202311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2566 최댓값
 * https://www.acmicpc.net/problem/2566
 */
public class _16_2566 {
    public static void main(String[] args) {

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            String read = null;
            int rowIdx = 0;
            int colIdx = 0;
            int max = -1;
            int curRow = 0;
            while((read = br.readLine()) != null) {
                curRow++;
                String[] line = read.split(" ");
                for (int i= 0; i < line.length ; i++) {
                    int tmp = Integer.parseInt(line[i]);
                    if (max < tmp) {
                        max = tmp;
                        colIdx = i + 1;
                        rowIdx = curRow;
                    }
                }
            }
            System.out.println(max);
            System.out.println(rowIdx + " " + colIdx);
        } catch (IOException e) {
            //TODO
        }
    }
}
