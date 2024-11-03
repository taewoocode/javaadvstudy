package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>( max );
    }

    @Override

    public void put(String data) {
        boolean result = queue.offer( data );
        log( "저장시도 결과 = " + result );
    }

    @Override
    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
