package thread.control;

import util.ThreadUtils;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    //예외를 던질 수 없다.
    /*static class CheckedRunnable implements Runnable {

        @Override
        public void run() {
            throw new Exception();
        }
    }*/

    static class CheckedRunnable implements Runnable {

        //자식예외는 던질 수 있음
        @Override
        public void run() {
            sleep( 1000 );
        }
    }
}
