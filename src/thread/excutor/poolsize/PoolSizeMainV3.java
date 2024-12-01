package thread.excutor.poolsize;

import thread.excutor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static thread.excutor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        log("pool 생성");
        printState(es);

        for (int i = 1; i < 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }
        es.close();
        log("===shut down=== 완료");

    }
}
