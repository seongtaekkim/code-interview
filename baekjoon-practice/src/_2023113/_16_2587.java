package _2023113;

import java.io.IOException;

/**
 * 2587 대표값2
 * https://www.acmicpc.net/problem/2587
 */
public class _16_2587 {
    public static void main(String[] args) throws IOException {
        int[] numbers = new int[5];
        for (int i=0 ; i<5 ; i++)
            numbers[i] = readInt();

        int sum=0;
        for (int i=0 ; i<5 ; i++)
            sum+=numbers[i];

        int tmp = 0;
        int minIdx = 0;
        for (int i=0 ; i<numbers.length-1 ; i++) {
            minIdx = i;
            for (int j=i+1 ; j<numbers.length ; j++) {
                if (numbers[minIdx] > numbers[j])
                    minIdx = j;
            }
            tmp = numbers[minIdx];
            numbers[minIdx] = numbers[i];
            numbers[i] = tmp;
        }

        System.out.println(sum/numbers.length);
        System.out.println(numbers[numbers.length/2]);
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
