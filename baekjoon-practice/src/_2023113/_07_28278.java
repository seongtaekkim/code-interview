package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 28278 스택 2
 * https://www.acmicpc.net/problem/28278
 */
public class _07_28278 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            Stack_28278 stack = new Stack_28278(num);
            StringBuilder sb = new StringBuilder();
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                if ("1".equals(line[0]))
                    stack.push(Integer.parseInt(line[1]));
                else if ("2".equals(line[0]))
                    sb.append(stack.pop()).append('\n');
                else if ("3".equals(line[0]))
                    sb.append(stack.size()).append('\n');
                else if ("4".equals(line[0]))
                    sb.append(stack.empty()).append('\n');
                else if ("5".equals(line[0]))
                    sb.append(stack.top()).append('\n');
            }
            System.out.println(sb);
        } catch (IOException e) {
            //TODO
        }

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

class Stack_28278 {
    int[] resources;
    int size;
    public Stack_28278(int num) {
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