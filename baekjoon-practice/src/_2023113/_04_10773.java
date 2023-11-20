package _2023113;

import java.io.IOException;

/**
 * 10773 제로
 * https://www.acmicpc.net/problem/10773
 */
public class _04_10773 {
    public static void main(String[] args) throws IOException {
        int num = readInt();
        int input;
        Stack_10773 stack = new Stack_10773(num);

        for (int i=0 ; i<num ; i++) {
            input = readInt();
            if (input == 0)
                stack.pop();
            else
                stack.push(input);
        }
        int sum =0;
        while (stack.top() != -1)
            sum += stack.pop();
        System.out.println(sum);

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

class Stack_10773 {
    int[] resources;
    int size;
    public Stack_10773(int num) {
        resources = new int[num];
        size = 0;
    }
    public void push(int data) {
        resources[size] = data;
        size++;
    }
    public int top() {
        if (this.size == 0)
            return -1;
        return this.resources[size-1];
    }
    public int pop() {
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