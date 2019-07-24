package com.springboot.tool.web.listen;

//import com.alibaba.ttl.TransmittableThreadLocal;
//import com.alibaba.ttl.TtlCallable;
//import com.alibaba.ttl.TtlRunnable;
//import com.alibaba.ttl.threadpool.TtlExecutors;
import javafx.concurrent.Task;
import org.slf4j.MDC;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenjunbin
 * @Date 2019/7/9
 * @Description
 */
public class test {
//    static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));
//
//    static TransmittableThreadLocal parent = new TransmittableThreadLocal();

    public static void main(String[] args) {
//        executorService.submit()
//        parent.set("value-set-in-parent");
//        System.out.println("000");
//        System.out.println("111");
//

//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(parent.get());
//            }
//        });
//
//        parent.set("value-set-in-parent2");
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(parent.get());
//            }
//        });
//        parent.set("value-set-in-parent3");
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(parent.get());
//            }
//        });
//
//        executorService.shutdown();



//// 额外的处理，生成修饰了的对象ttlCallable
////        executorService.submit(ttlCallable);
//        CompletableFuture.runAsync(() -> {
//            TtlRunnable.get(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("s" + parent.get());
//                }
//            });
//        }, executorService);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    }
}
