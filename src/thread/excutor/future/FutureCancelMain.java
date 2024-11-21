package thread.excutor.future;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptRunning = true;
    //private static boolean mayInterruptRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future.state: " + future.state());

        //일정 시간 후 취소 시도
        sleep(8000);


        //cancel
        log("futrue.cancel(" + mayInterruptRunning + ") 호출");
        boolean cancelResult = future.cancel(mayInterruptRunning);
        log("futrue.cancel(" + mayInterruptRunning + ") result: " + cancelResult);

        // 결과 확인
        try {
            log("Future result: " + future.get());
        } catch (CancellationException e) {
            log("Future는 이미 취소 되었습니다.");
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call(){
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업 중: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                log("인터럽트 발생");
                return "Interrupted";
            }
            return "Completed";
        }
    }
}
