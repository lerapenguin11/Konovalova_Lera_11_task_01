package com;

public class StateObject {
    private int x;
    private int count;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void run() {
        while (x < 999999) {
            x++;
            if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                    % 10 + (x / 10000) % 10 + (x / 100000) % 10) {
                System.out.println(x);
                count++;
            }
        }
    }
}
