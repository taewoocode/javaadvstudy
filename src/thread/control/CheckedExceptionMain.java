package thread.control;

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


}
