package _2023113;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 2750 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
public class _15_2750 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = readInt();
        int[] numbers = new int[num];
        for (int i=0 ; i<num ; i++)
            numbers[i] = readInt();

        int tmp = 0;
        int minIdx = 0;
        for (int i=0 ; i<num-1 ; i++) {
            minIdx = i;
            for (int j=i+1 ; j<num ; j++) {
                if (numbers[minIdx] > numbers[j])
                    minIdx = j;
            }
            tmp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = tmp;
        }
        for (int i : numbers)
            bw.write(i+"\n");
        bw.flush();
    }

    static int readInt() throws IOException {
        int sum = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return isNegative ? sum * -1 : sum;
            else if (input == '-')
                isNegative = true;
            else
                sum = (sum * 10) + input - '0';
        }
    }
}
