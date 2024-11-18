package thread.collection.simple.list;

import java.util.Vector;

import static util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
//        test( new SyncList() );
        test( new SyncProxyList( new BasicList() ) );
    }

    private static void test(SimpleList list) throws InterruptedException {
        log( list.getClass().getSimpleName() );

        //A를 List에 저장하는 코드
        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add( "A" );
                log( "Thread-1: list.add(A)" );
            }
        };

        //B를 List에 저장하는 코드
        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add( "B" );
                log( "Thread-2: list.add(B)" );
            }
        };

        Thread thread1 = new Thread( addA, "Thread-1" );
        Thread thread2 = new Thread( addB, "Thread-2" );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log( list );

    }
}
