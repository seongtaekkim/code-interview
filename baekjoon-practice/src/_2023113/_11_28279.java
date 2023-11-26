package _2023113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 28279 덱 2
 * https://www.acmicpc.net/problem/28279
 */
public class _11_28279 {
    public static void main(String[] args) {
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(System.in))) {

            int num = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            Deck deck = new Deck(num);
            for (int i=0 ; i<num ; i++) {
                String[] line = br.readLine().split(" ");
                if ("1".equals(line[0]))
                    deck.push_front(Integer.parseInt(line[1]));
                else if ("2".equals(line[0]))
                    deck.push_back(Integer.parseInt(line[1]));
                else if ("3".equals(line[0]))
                    sb.append(deck.pop_front()).append("\n");
                else if ("4".equals(line[0]))
                    sb.append(deck.pop_back()).append("\n");
                else if ("5".equals(line[0]))
                    sb.append(deck.size()).append("\n");
                else if ("6".equals(line[0]))
                    sb.append(deck.empty()).append("\n");
                else if ("7".equals(line[0]))
                    sb.append(deck.front()).append("\n");
                else if ("8".equals(line[0]))
                    sb.append(deck.back()).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            //TODO
        }
    }
}

class Deck {
    int[] resources;
    int frontIdx;
    int backIdx;
    int size;
    public Deck(int num) {
        resources = new int[num];
        frontIdx = -1;
        backIdx = -1;
        size = 0;
    }
    public void push_front(int data) {
        if (frontIdx == -1) {
            frontIdx = 0;
            backIdx = 0;
        } else if (frontIdx == 0)
            frontIdx = resources.length-1;
        else
            frontIdx--;
        resources[frontIdx] = data;
        this.size++;
    }
    public void push_back(int data) {
        if (backIdx == -1) {
            frontIdx = 0;
            backIdx = 0;
        } else if (backIdx+1 == resources.length)
            backIdx = 0;
        else
            backIdx++;
        resources[backIdx] = data;
        this.size++;
    }
    public int pop_front() {
        if (this.frontIdx == -1)
            return -1;
        int ret = this.resources[this.frontIdx];
        if (this.frontIdx == this.backIdx) {
            this.frontIdx = -1;
            this.backIdx = -1;
        } else
            this.frontIdx = (this.frontIdx == this.resources.length-1) ? 0 : this.frontIdx+1;
        this.size--;
        return ret;
    }
    public int pop_back() {
        if (this.backIdx == -1)
            return -1;
        int ret = this.resources[this.backIdx];
        if (this.frontIdx == this.backIdx) {
            this.frontIdx = -1;
            this.backIdx = -1;
        } else
            this.backIdx = (this.backIdx == 0) ? this.resources.length-1 : this.backIdx-1;
        this.size--;
        return ret;
    }
    public int front() {
        if (this.frontIdx == -1)
            return -1;
        return this.resources[this.frontIdx];
    }
    public int back() {
        if (this.backIdx == -1)
            return -1;
        return this.resources[this.backIdx];
    }
    public int size() {
        return this.size;
    }
    public int empty() {
        if (this.size > 0)
            return 0;
        return 1;
    }
}
