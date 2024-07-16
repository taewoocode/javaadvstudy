package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println( Thread.currentThread().getName() + ": main() start" );

        HelloThread helloThread = new HelloThread();
        System.out.println( Thread.currentThread().getName() + "start 호출 전" );
        helloThread.start(); //호출하면 새로운 Thread-0에게
        System.out.println( Thread.currentThread().getName() + "start 호출 후" );

        System.out.println( Thread.currentThread().getName() + ": main() end" );


    }
}
