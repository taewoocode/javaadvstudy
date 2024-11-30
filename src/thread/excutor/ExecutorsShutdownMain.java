package thread.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static thread.excutor.ExecutorUtils.*;
import static util.MyLogger.log;

public class ExecutorsShutdownMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("LongTask", 100_100));
        printState(es);
        log("=========shut down 시작 ========");
        shutdownAndAwaitTermination(es);
        log("=========shut down 시작 ========");
        printState(es);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown(); // 새로운 작업을 받지 않고, 기존 작업을 처리

        try {
            // 기존 작업이 완료되도록 10초 대기
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                log("서비스 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow(); // 강제 종료 시도 (대기 중인 작업 취소 및 실행 중인 작업 인터럽트)
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 여전히 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            log("인터럽트 발생, 강제 종료 시도");
            es.shutdownNow();
        }
    }
}
