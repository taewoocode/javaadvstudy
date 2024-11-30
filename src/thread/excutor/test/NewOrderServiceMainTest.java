package thread.excutor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceMainTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String orderNo = "Order#1234";
        NewOrderService orderService = new NewOrderService();
        orderService.order(orderNo);
    }


}
