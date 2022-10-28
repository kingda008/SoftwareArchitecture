package com.baoge.gaohuantang;

public class Eit {

    public static void main(String[] args) {
        Thread t = new Task();
        t.start();

        Thread t2 = new Thread(new TaskRunable());
        t2.start();
    }



    static class Task extends Thread {
        @Override
        public void run() {
            super.run();
            //TODO do some thing
        }
    }




    static class TaskRunable implements  Runnable{
        @Override
        public void run() {
            //TODO do some thing
        }
    }
}
