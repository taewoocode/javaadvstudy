package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread( task, ":work" );
        thread.start();

        sleep( 4000 );
        log( "작업 중단 지시 runFlag = false" );
        task.runFlag = false;
    }


    //작업을 진행하는 스레드 하나 만들기
    static class MyTask implements Runnable {

        //키워드
        //플래그 값이 false가 되면 작업이 중단된다.
        volatile boolean runFlag = true;


        @Override
        public void run() {
            while (runFlag) {
                log( "작업중" );
                sleep( 3000 );

            }
            log( "자원 정리" );
            log( "자원 종료" );
        }
    }
}
