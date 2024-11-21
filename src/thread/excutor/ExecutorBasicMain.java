package thread.excutor;

import java.util.concurrent.*;

import static thread.excutor.ExecutorUtils.*;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor( 2, 2, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>() );
        log( "== 초기 상태 == " );
        printState( es );
        es.execute( new RunnableTask( "taskA" ) );
        es.execute( new RunnableTask( "taskB" ) );

        //여기서 부터는 재사용이 된다. 풀이 2개가 최대니까
        es.execute( new RunnableTask( "taskC" ) );
        es.execute( new RunnableTask( "taskD" ) );
        log( "== 작업 수행 중 == " );
        printState( es );

        sleep( 3000 );
        log( "== 작업 수행 완료 == " );
        printState( es );

        es.close();
        log( "== shutdown == " );
        printState( es );

    }
}
