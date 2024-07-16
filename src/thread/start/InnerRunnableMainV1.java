package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log( "main() start" );
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread( myRunnable );
        thread.start();
        log( "main() end" );

    }

    //중첩 클래스를 만드는 이유는 여러 곳에 사용하기 보다는 하나의 클래스에 종속되서 사용된다.
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log( "run()" );
        }
    }
}



