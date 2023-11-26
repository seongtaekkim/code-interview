package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1935 후위 표기식 2
 * https://www.acmicpc.net/problem/1935
 */
public class _13_1935 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            char[] data = br.readLine().toCharArray();
            int[] numbers = new int[26];
            for (int i=0 ; i<num ; i++)
                numbers[i] = Integer.parseInt(br.readLine());

            Stack_1935 stack = new Stack_1935(data.length);

            // ABC*+DE/-
            for (int i=0 ; i<data.length ; i++) {
                if ((int)data[i] >= 65 && (int)data[i] <= 90) {
                    stack.push(numbers[data[i] - 'A']);
                } else {
                    double second = stack.pop();
                    double first = stack.pop();
                    double ret = 0;
                    if (data[i] == '+')
                        ret = first + second;
                    else if (data[i] == '-')
                        ret = first - second;
                    else if (data[i] == '*')
                        ret = first * second;
                    else if (data[i] == '/') {
                        if (second == 0)
                            throw new ArithmeticException("divide by 0");
                        ret = first / second;
                    }
                    stack.push(ret);
                }
            }
            System.out.printf("%.2f", stack.pop());
        } catch (IOException e) {
            //TODO
        }

    }
}

class Stack_1935 {
    double[] resources;
    int size;
    public Stack_1935(int num) {
        resources = new double[num];
        size = 0;
    }
    public void push(double data) {
        resources[size] = data;
        size++;
    }
    public double top() {
        if (this.size == 0)
            return -1;
        return this.resources[size-1];
    }
    public double pop() {
        if (this.size == 0)
            return -1;
        this.size--;
        return this.resources[this.size];
    }
    public int size() {
        return size;
    }
    public int empty() {
        if (size > 0)
            return 0;
        return 1;
    }
}
