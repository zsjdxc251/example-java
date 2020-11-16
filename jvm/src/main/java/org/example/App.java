package org.example;

/**
 * Hello world!
 *
 * -Xmx50M
 * -XX:MaxMetaspaceSize=50M
 *
 * -XX:+PrintFlagsFinal 打印设置   冒号表达手动设置过
 *
 */
public class App
{

    public final static byte[] bytes = new byte[1024*1024*30];
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );

        Thread.currentThread().join();
    }
}
