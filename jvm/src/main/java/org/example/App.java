package org.example;

/**
 * Hello world!
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
