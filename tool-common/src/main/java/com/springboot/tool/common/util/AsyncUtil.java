package com.springboot.tool.common.util;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @Author chenjunbin
 * @Date 2019/7/31
 * @Description 异步并发执行任务工具类
 */
public class AsyncUtil {
    private static final Logger log = LoggerFactory.getLogger(AsyncUtil.class);

    //private static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    private static ExecutorService executor;

    static {
        executor = new ThreadPoolExecutor(5, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("threadPoll shutdown ...");
            executor.shutdown();
        }));
    }

    /**
     * 并发执行任务,未设置超时时间(存在隐式异常情况，需要调用方处理)
     *
     * @param suppliers
     * @param <T>
     * @return
     */
    public static <T> List<T> executeThrown(Supplier<T>... suppliers) {
        if (suppliers == null || suppliers.length == 0) {
            return Lists.newArrayList();
        }
        List<T> result = Lists.newArrayList();
        for (CompletableFuture<T> future : getCompletableFuture(suppliers)) {
            result.add(future.join());
        }
        return result;
    }


    public static <T> List<T> execute(Supplier<T>... suppliers) {
        return execute(-1, null, suppliers);
    }

    /**
     * 并发执行任务,出现异常则返回null
     *
     * @param timeout
     * @param unit
     * @param suppliers
     * @param <T>
     * @return
     */
    public static <T> List<T> execute(long timeout, TimeUnit unit, Supplier<T>... suppliers) {
        if (suppliers == null || suppliers.length == 0) {
            return Lists.newArrayList();
        }

        int activeThreadCount = ((ThreadPoolExecutor) executor).getActiveCount();
        if (activeThreadCount > 10) {
            log.info("AsyncUtil active thread count:{}" + activeThreadCount);
        }

        List<T> result = Lists.newArrayList();
        for (CompletableFuture<T> future : getCompletableFuture(suppliers)) {
            T t = null;
            try {
                t = timeout > 0 ? future.get(timeout, unit) : future.get();
            } catch (Exception e) {
                log.error("future.get exception:{}", e);
            }
            result.add(t);
        }
        return result;
    }

    private static <T> List<CompletableFuture<T>> getCompletableFuture(Supplier<T>[] suppliers) {
        List<CompletableFuture<T>> list = new ArrayList<>();
        final String traceId = ThreadMDCUtil.getTraceId();
        for (Supplier<T> supplier : suppliers) {
            CompletableFuture<T> future = CompletableFuture.supplyAsync(() -> {
                ThreadMDCUtil.setTraceId(traceId + "-" + supplier.hashCode());
                try {
                    return supplier.get();
                } finally {
                    ThreadMDCUtil.clean();
                }

            }, executor);
            list.add(future);
        }
        return list;
    }


    /**
     * 异步执行
     *
     * @param tasks
     */
    public static void executeRunnable(Runnable... tasks) {
        if (tasks == null || tasks.length == 0)
            return;
        final String traceId = ThreadMDCUtil.getTraceId();
        for (Runnable task : tasks) {
            CompletableFuture.runAsync(() -> {
                System.out.println("traceId："+traceId);
                ThreadMDCUtil.setTraceId(traceId + "-" + task.hashCode());
                try {
                    task.run();
                } catch (Exception e) {
                    log.error("task.run error:", e);
                } finally {
                    ThreadMDCUtil.clean();
                }
            }, executor);
        }
    }
}
