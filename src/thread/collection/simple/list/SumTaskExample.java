package thread.collection.simple.list;

public class SumTaskExample {
    private int result;

    public void calculateSum(int a, int b) throws InterruptedException {
        class SumTask implements Runnable {
            @Override
            public void run() {
                result = a + b;
            }
        }
        SumTask sumTask = new SumTask();
        Thread thread = new Thread( sumTask );
        thread.start();
        thread.join();
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        SumTaskExample sumTaskExample = new SumTaskExample();
        sumTaskExample.calculateSum( 5, 10 );
        System.out.println( "sumTaskExample = " + sumTaskExample.getResult() );
    }
}
