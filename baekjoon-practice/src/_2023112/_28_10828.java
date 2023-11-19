package _2023112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10828 스택
 * https://www.acmicpc.net/problem/10828
 */
public class _28_10828 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            Stack stack = new Stack(num);
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                if ("push".equals(line[0]))
                    stack.push(Integer.parseInt(line[1]));
                else if ("pop".equals(line[0]))
                    System.out.println(stack.pop());
                else if ("size".equals(line[0]))
                    System.out.println(stack.size());
                else if ("empty".equals(line[0]))
                    System.out.println(stack.empty());
                else if ("top".equals(line[0]))
                    System.out.println(stack.top());
            }
        } catch (IOException e) {
            //TODO
        }
    }
}

class Stack {
    int[] resources;
    int size;
    public Stack(int num) {
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