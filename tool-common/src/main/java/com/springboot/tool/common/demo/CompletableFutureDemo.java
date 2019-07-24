package com.springboot.tool.common.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BinaryOperator;

/**
 * @Author chenjunbin
 * @Date 2019/7/5
 * @Description
 *
 * CompletableFuture
 * 1、runAsync 异步执行无返回值
 * 2、supplyAsync 异步执行有返回值
 * 3、thenApply 进行交换，上次的返回值作为下次交换的参数，有返回值
 * 4、thenAccept 进行消费，上次的返回值作为下次交换的参数，无返回值
 * 5、thenRun 对上一步的计算结果不关心，执行下一个操作。（先执行完上一步才能执行下一步）
 * 6、thenCombine 结合两个CompletionStage的结果，进行转化后返回，有返回值
 * 7、thenAcceptBoth 结合两个CompletionStage的结果，进行消耗，无返回值
 * 8、runAfterBoth 在两个CompletionStage都运行完执行，无返回值（不关心这两个CompletionStage的结果）
 * 9、applyToEither 两个CompletionStage，谁计算的快，就用快的那个CompletionStage的结果进行下一步的转化操作，有返回值
 * 10、acceptEither 两个CompletionStage，谁计算的快，就用快的那个CompletionStage的结果进行下一步的消耗操作，无返回值
 * 11、runAfterEither 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable），无返回值
 * 12、exceptionally 当运行时出现了异常，可以通过exceptionally进行补偿， 有返回值。
 * 13、whenComplete 当运行完成时，对结果的记录，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。第一个参数为返回结果，第二个为异常信息，无返回值
 * 14、handle 运行完成时，对结果的处理。一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。第一个参数为返回结果，第二个为异常信息，有返回值
 *
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> runAsync = CompletableFuture
                .runAsync(() -> System.out.println("hello"));
        CompletableFuture<String> supplyAsync1 = CompletableFuture.supplyAsync(() -> {
            return "hello world";
        }).thenApplyAsync(s -> {
            System.out.println("--+-");
            return s + "哈哈1";
        });
        CompletableFuture.supplyAsync(() -> {
            System.out.println("1");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11");
            return "hello world";
        }).thenRun(()-> System.out.println("s"));

        System.out.println("2222");
        Thread.sleep(3000L);
        System.out.println("22");
//        System.out.println(supplyAsync2.get());

//        BinaryOperator<String> calcResults = (f, s) -> f + "$++$" + s;
//        CompletableFuture<String> combined =
//                supplyAsync1.thenCombineAsync(supplyAsync2, calcResults);
//        System.out.println("combined.get():" + combined.get());

//        CompletableFuture<String> combined2 =
//                supplyAsync1.runAfterBothAsync(supplyAsync2,
//                        () -> System.out.println(supplyAsync1.get() + "," + supplyAsync2.get());
//                        );

//        System.out.println("combined2.get():" + combined2.get());

//        CompletableFuture<Void> collector = supplyAsync1.acceptEither(supplyAsync2,(s)-> System.out.println(s));


    }
}
