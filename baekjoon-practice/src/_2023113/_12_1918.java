package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1918 후위 표기식
 * https://www.acmicpc.net/problem/1918
 */
public class _12_1918 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            // A*(B+C) -> ABC+*
            // +, -, *, /, (, )
            char[] data = br.readLine().toCharArray();

            Stack_1918 stack = new Stack_1918(data.length);
            char[] ret = new char[data.length];
            int retIdx =0;
            for (int i=0 ; i<data.length ; i++) {
                if ((int)data[i] >= 65 && (int)data[i] <= 90)
                    ret[retIdx++] = data[i];
                else {
                    if (data[i] == '(')
                        stack.push(data[i]);
                    else if (data[i] == ')') {
                        while (stack.top() != '(')
                            ret[retIdx++] = stack.pop();
                        stack.pop();
                    }
                    else if (data[i] == '+' || data[i] == '-') {
                        while (stack.top() == '+' || stack.top() == '-' || stack.top() == '*' || stack.top() == '/')
                            ret[retIdx++] = stack.pop();
                        stack.push(data[i]);
                    }
                    else if (data[i] == '*' || data[i] == '/') {
                        while (stack.top() == '*' || stack.top() == '/')
                            ret[retIdx++] = stack.pop();
                        stack.push(data[i]);
                    }
                }
            }
            while (stack.size() != 0)
                ret[retIdx++] = stack.pop();
            for (int i=0 ;i<retIdx ; i++)
                System.out.print(ret[i]);


        } catch (IOException e) {
            //TODO
        }

    }
}

class Stack_1918 {
    char[] resources;
    int size;
    public Stack_1918(int num) {
        resources = new char[num];
        size = 0;
    }
    public void push(char data) {
        resources[size] = data;
        size++;
    }
    public char top() {
        if (this.size == 0)
            return 0;
        return this.resources[size-1];
    }
    public char pop() {
        if (this.size == 0)
            return 0;
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
