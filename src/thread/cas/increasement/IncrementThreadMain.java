package thread.cas.increasement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test( new SyncInteger() );
        test( new MyAtomicInteger() );
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sleep( 10 );
                incrementInteger.increment();
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread( runnable );
            threads.add( thread );
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println( incrementInteger.getClass().getSimpleName() + " result: " + result );
    }
}
