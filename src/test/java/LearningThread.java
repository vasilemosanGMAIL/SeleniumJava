public class LearningThread extends Thread {
    public static void main(String[] args) {
        LearningThread thread = new LearningThread();
        thread.start();

        System.out.println("Outside of a thread");
    }

    @Override
    public void run() {
        System.out.println("Inside of a thread");
    }
}

class LearningThread2 implements Runnable {
    public static void main(String[] args) {
        LearningThread2 thread = new LearningThread2();
        Thread threadObject = new Thread(thread);
        threadObject.start();

        System.out.println("Outside of a thread");
    }

    @Override
    public void run() {
        System.out.println("Inside of a thread");
    }
}

class LearningThread3 extends Thread {
    public static void main(String[] args) {
        //Order of starting Threads is not sequential
        for (int i = 0; i < 6; i++) {
            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread: " + getName() + " running");
                }
            }
                    .start();
        }
    }
}