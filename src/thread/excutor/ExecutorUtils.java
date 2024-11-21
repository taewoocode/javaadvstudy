package thread.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public class ExecutorUtils {

    public static void printState(ExecutorService executorService) {

        //ThreadPoolExecutor abc = (ThreadPoolExecutor) executorService;
        //executorService를 ThreadPoolExecutor로 Casting
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            log( "[pool=" + pool + ", active=" + active +
                    ", queuedTasks=" + queuedTasks + ", completedTask=" + completedTask + "]" );
        } else {
            log( executorService );
        }
    }
}
