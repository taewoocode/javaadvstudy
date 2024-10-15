package thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV5 implements BankAccount {

    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountV5(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        try {
            if (!lock.tryLock( 500, TimeUnit.MILLISECONDS )) {
                log( "[진입 실패] 이미 처리중인 작업이 있습니다." );
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }

        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000); // 출금에 걸리는 시간
            balance = balance - amount;

            // 잔고가 출금액보다 많으면, 진행
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
            return true; // 출금 성공
        } finally {
            lock.unlock(); // 항상 락을 해제
        }
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        }finally {
            //락을 해제
            lock.unlock();
        }
    }
}
