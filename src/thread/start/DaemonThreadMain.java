package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon( true ); //daemonthread 여부
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {

        @Override
        public void run() {
            System.out.println( Thread.currentThread().getName() + ": run()" );

            try {
                Thread.sleep( 10000 ); //10초간 실행 (가상 시뮬레이터)

            } catch (InterruptedException e) {
                throw new RuntimeException( e );
            }
            System.out.println( Thread.currentThread().getName() + ": run() end" );
        }
    }
}
