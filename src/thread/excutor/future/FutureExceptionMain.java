package thread.excutor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionMain {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000);
        try {
            log("future.get() 호출 시도, future.state()" + future.state());
            Integer result = future.get();
            log("result value: = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e); //생성자로 던짐(예외)
        } catch (ExecutionException e) { //실행예외
            log("e= " + e);
            Throwable cause = e.getCause();
            log("cause = " + cause);
        }
        es.close();
    }

    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}
