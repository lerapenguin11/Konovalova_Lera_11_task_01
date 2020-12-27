package com;

public class Lucky {
    static int count = 0;
    private static StateObject stateObject;

    static class LuckyThread extends Thread {
        public LuckyThread(StateObject object) {
            stateObject = object;
        }

        @Override
        public void run() {
            stateObject.run();
            count = stateObject.getCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StateObject stateObject = new StateObject();
        Thread t1 = new LuckyThread(stateObject);
        Thread t2 = new LuckyThread(stateObject);
        Thread t3 = new LuckyThread(stateObject);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}
