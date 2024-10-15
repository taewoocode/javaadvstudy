package thread.sync.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread( new ParkTest(), "Thread-1" );
        thread1.start();

        //waiting
        sleep( 100 );
        log( "Thread-1 state: " + thread1.getState() );
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log( "park 시작" );
            LockSupport.parkNanos(2000_000000);
            log( "park 종료" + Thread.currentThread().getState() );
            log( "인터럽트 상태 " + Thread.currentThread().isInterrupted() );
        }

    }
}
