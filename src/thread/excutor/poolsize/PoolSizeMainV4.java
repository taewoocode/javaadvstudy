package thread.excutor.poolsize;

import thread.excutor.RunnableTask;

import java.util.concurrent.*;

import static thread.excutor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV4 {

    static final int TASK_SIZE = 1100; // 1.일반
//    static final int TASK_SIZE = 1200; // 2.긴급
//    static final int TASK_SIZE = 1201; // 3.거절

    public static void main(String[] args) {
        ThreadPoolExecutor es = new ThreadPoolExecutor(100, 200,
                60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        printState(es);
        long startMs = System.currentTimeMillis();
        es.close();
        long endMs = System.currentTimeMillis();
        for (int i = 1; i < TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es,taskName);

            } catch (RejectedExecutionException e) {
                log(taskName + " -> " + e);
            }
        }
        log("time: " + (endMs - startMs));

    }
}
