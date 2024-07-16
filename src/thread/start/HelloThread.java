package thread.start;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + "run()" ); //현재 스레드를 출력

    }
}
