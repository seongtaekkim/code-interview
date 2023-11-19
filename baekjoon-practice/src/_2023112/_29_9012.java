package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9012 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class _29_9012 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            Stack_9012 stack;
            boolean flag = true;
            for (int i=0 ; i<num ; i++) {
                char[] charArray = br.readLine().toCharArray();
                stack = new Stack_9012(num);
                flag = true;
                for (char c : charArray) {
                    if ('(' == c)
                        stack.push(c);
                    else if (')' == c) {
                        if (stack.top() == '(')
                            stack.pop();
                        else {
                            flag = false;
                            break ;
                        }
                    }
                }
                if (stack.size() > 0 || !flag)
                    System.out.println("NO");
                else
                    System.out.println("YES");

            }
        } catch (IOException e) {
            //TODO
        }
    }
}

class Stack_9012 {
    char[] resources;
    int size;
    public Stack_9012(int num) {
        resources = new char[num];
        size = 0;
    }
    public void push(char data) {
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