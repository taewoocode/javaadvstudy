package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        log( "main() start" );

        //익명 클래스로도 만들 수 있음
        Thread thread = new Thread( () -> log( "run()" ) );
        thread.start();
        log( "main() end" );

    }
}



