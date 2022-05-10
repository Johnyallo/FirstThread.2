package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<MyCallable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable();
            list.add(myCallable);
        }
        List<Future<Integer>> resultList = null;
        //Integer resultList = null;

        try {
            resultList = executor.invokeAll(list);
            //resultList = executor.invokeAny(list);
        //} catch (InterruptedException | ExecutionException e) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----");
        System.out.println(MyCallable.result);
        executor.shutdown();
    }
}
