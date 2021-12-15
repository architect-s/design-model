package com.example.designmodel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class DesignModelApplicationTests {


    @Test
    void test() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> getDataById(10)).thenApply(data -> sendData(data));
        System.out.println(cf.get());
    }

    private String getDataById(int id) {
        System.out.println("getDataById-" + Thread.currentThread().getName());
        return "Data1:" + id;
    }

    private String sendData(String data) {
        System.out.println("sendData-" + Thread.currentThread().getName());
        System.out.println(data);
        return data;
    }

    @Test
    void contextLoads() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "HelloWorld");
        System.out.println(stringCompletableFuture.get());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> "HelloWorld", executorService);
        System.out.println(stringCompletableFuture1);
        System.out.println(stringCompletableFuture1.get());
    }
}
