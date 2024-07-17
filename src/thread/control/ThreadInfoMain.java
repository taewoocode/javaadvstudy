package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        //mainThread
        Thread mainThread = Thread.currentThread();
        log( "mainThread() = " + mainThread );
        log( "mainThread.thread() = " + mainThread.threadId() );
        log( "mainThread.getName() = " + mainThread.getName() );
        log( "mainThread.getPriority() = " + mainThread.getPriority() );
        log( "mainThread.getThreadGroup() = " + mainThread.getThreadGroup() );
        log( "mainThread.getState() = " + mainThread.getState() );


        //myThread
        Thread myThread = new Thread( new HelloRunnable() );
        log( "myThread() = " + myThread );
        log( "myThread.thread() = " + myThread.threadId() );
        log( "myThread.getName() = " + myThread.getName() );
        log( "myThread.getPriority() = " + myThread.getPriority() ); //기본값이 5
        log( "myThread.getThreadGroup() = " + myThread.getThreadGroup() );
        log( "myThread.getState() = " + myThread.getState() ); //NEW

    }
}
