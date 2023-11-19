package _2023112;

import java.io.IOException;

/**
 * 1874 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class _30_1874 {
    public static void main(String[] args) throws IOException {
        int num = readInt();
        Stack_1874 stack;
        boolean flag = true;
        int seq = 1;
        StringBuilder sb = new StringBuilder();
        stack = new Stack_1874(num);
        for (int i=0 ; i<num ; i++) {
            int data = readInt();
            while (true) {
                if (data == stack.top()) {
                    stack.pop();
                    sb.append("-\n");
                    break ;
                }
                if (seq == num+1) {
                    flag = false;
                    break;
                }
                stack.push(seq++);
                sb.append("+\n");
            }
        }

        if (!flag)
            System.out.println("NO");
        else
            System.out.println(sb);
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

class Stack_1874 {
    int[] resources;
    int size;
    public Stack_1874(int num) {
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
