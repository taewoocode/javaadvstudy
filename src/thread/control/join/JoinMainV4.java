package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {
        log( "Start" );
        SumTask task1 = new SumTask( 51, 100 );
        Thread thread1 = new Thread( task1, "thread1" );

        thread1.start();

        //스레드가 종료될 때 까지 대기
        //thread1, thread2의 작업이 종료되면 main thread의 작업이 종료된다.
        log( "join(1000) - main 스레드가 thread1 종료까지 1초 대기" );
        thread1.join( 1000 );

        log( "task1.result = " + task1.result );
        log( "End" );
    }

    static class SumTask implements Runnable {

        int startValue; //0
        int endValue; //0
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log( "작업 시작" );
            sleep( 2000 );
            int sum = 0;
            for (int i = startValue; i < endValue; i++) {
                sum += i;
            }
            result = sum;
            log( "작업 완료 + result = " + result );

        }
    }
}
