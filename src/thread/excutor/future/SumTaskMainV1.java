package thread.excutor.future;

import static util.MyLogger.log;

public class SumTaskMainV1 {


    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue, int result) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업시작");

        }
    }
}

