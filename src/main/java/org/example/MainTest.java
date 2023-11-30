package org.example;

import java.util.function.Function;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        doSomething(input->{
            String result = input +"Hello Function";
            return result;
        });
    }

    public static void doSomething(Function<String,String> function){
        String name = "Adam";
        final String result = function.apply(name);
        System.out.println(result);
    }
}
