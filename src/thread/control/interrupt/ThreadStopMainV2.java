package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread( task, ":work" );
        thread.start();

        sleep( 4000 );
        log( "작업 중단 지시 thread.interrupt()" );
        thread.isInterrupted();
        log( "work 스레드 인터럽트 상태1 = " + thread.isInterrupted() );
    }


    //작업을 진행하는 스레드 하나 만들기
    static class MyTask implements Runnable {

        //키워드
        //플래그 값이 false가 되면 작업이 중단된다.


        @Override
        public void run() {
            try {
                while (true) {
                    log( "작업중" );
                    //exception이 발생하면 catch로 넘어간다.
                    Thread.sleep( 3000 );
                }
            } catch (InterruptedException e) {
                log( "work thread 인터럽트 상태2 = " + Thread.currentThread().isInterrupted() );
                log( "interrupt message = " + e.getMessage() );
                log( "state = " + Thread.currentThread().getState() );
            }
            log( "자원 정리" );
            log( "자원 종료" );
        }
    }
}
