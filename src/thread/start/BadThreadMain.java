package thread.start;

public class BadThreadMain {
    public static void main(String[] args) {
        System.out.println( Thread.currentThread().getName() + ": main() start" );

        HelloThread helloThread = new HelloThread();
        System.out.println( Thread.currentThread().getName() + "start 호출 전" );
        helloThread.run(); //run을 호출하면 main-thread가 실행한다.
        System.out.println( Thread.currentThread().getName() + "start 호출 후" );

        System.out.println( Thread.currentThread().getName() + ": main() end" );


    }
}
