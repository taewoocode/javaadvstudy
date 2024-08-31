package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread( task, ":work" );
        thread.start();

        sleep( 100 ); //지정된 시간동안 스레드를 멈춘다.
        log( "작업 중단 지시 thread.interrupt()" );
        thread.interrupt();
        log( "work 스레드 인터럽트 상태1 = " + thread.isInterrupted() );
    }


    //작업을 진행하는 스레드 하나 만들기
    static class MyTask implements Runnable {

        //키워드
        //플래그 값이 false가 되면 작업이 중단된다.


        @Override
        public void run() {
            while (!Thread.interrupted()) { //Interrupted가 걸린게 아니면
                log( "작업 중" );

            }
            log( "work thread 인터럽트 상태2 = " + Thread.interrupted() );

            try {
                log( "자원 정리" );
                Thread.sleep(1000);
                log( "자원 종료" );
            } catch (InterruptedException e) {
                log( "자원 정리 실패 - 자원 정리 중 인터럽트 발생" );
                log( "work thread 인터럽트3 상태 = " + Thread.currentThread().isInterrupted() );
            }
            log( "작업 종료" );
        }
    }
}
