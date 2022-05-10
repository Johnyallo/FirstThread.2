package Main;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    static int result = 0;
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1500);
        System.out.println("I am " + Thread.currentThread().getName() + ". Hello!");
        result++;
        return result;
    }
}
