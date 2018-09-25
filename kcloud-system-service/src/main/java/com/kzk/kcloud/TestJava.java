package com.kzk.kcloud;

import sun.management.counter.StringCounter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestJava {
    public static int vol = 0;
    public static int a = 1;
    public static int b = 2;

    private static volatile TestJava ins = null;

    private TestJava(){
        System.out.println("TestJava===================" + Thread.currentThread().getName());
    }

    public static TestJava getIns(){
        if(ins == null){
            synchronized(TestJava.class){
                if(ins == null){
                    System.out.println(Thread.currentThread().getName() + "--->>> ");
                    ins = new TestJava();
                    System.out.println(Thread.currentThread().getName() + "---<<< ");
                }
            }
        }
        return ins;
    }


    public static String readFile() throws IOException {
        String path = "/testFile.txt";
        InputStream is = new FileInputStream(path);
        StringBuilder sb = new StringBuilder();
//        byte[] buffer = new byte[128];
//        b = -1;
//        do {
//            int i = 0;
//            Arrays.fill(buffer,(byte)-1);
//            do {
//                b = is.read();
//                buffer[i] = (byte)b;
//                i++;
//                if(b==-1 && i>0 || i==buffer.length){
//                    sb.append(new String(Arrays.copyOf(buffer,i-1), "utf8"));
//                    break;
//                }
//            }while(b!=-1);
//
//        }while(b!=-1);

        InputStreamReader isr = new InputStreamReader(is,"utf8");
        FileReader fr = new FileReader(path);
       BufferedReader br = new BufferedReader(isr);
        BufferedReader br2 = new BufferedReader(fr);

        System.out.println(br.readLine());
        System.out.println(br2.readLine());
        return sb.toString();
    }



    public static void main(String[] args) throws IOException {
        System.out.println(readFile());

//        DelayObj dobj1 = new DelayObj(5, TimeUnit.SECONDS);
//        System.out.println(dobj1.getDelay(TimeUnit.SECONDS));
//
//        DelayQueue<DelayObj> dq = new DelayQueue<DelayObj>();
//        dq.put(new DelayObj(5, TimeUnit.SECONDS));
//        dq.put(new DelayObj(10, TimeUnit.SECONDS));
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            DelayObj dobj = dq.take();
//            System.out.println(dobj.getDelay(TimeUnit.SECONDS));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        List<String> list = (List<String>)Collections.synchronizedList(new ArrayList<String>());
//        list.wait();
//        list.notify();
//        list.notifyAll();
//        Thread.sleep();
//        Thread  t;
//        Thread.yield()
//        t.interrupt();
//
//
//        Thread[] threads = new Thread[10];
//        for(Thread thread : threads){
//            thread = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
////                    for(int i=0;i<100;i++){
////                        vol++;
//                        System.out.println(Thread.currentThread().getName() + ">>> ");
//                        getIns();
//                        System.out.println(Thread.currentThread().getName() + "<<< ");
////                    }
//                }
//            });
//            thread.start();
//
//        }

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = b;
//                vol = 1;
//
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(vol==0){
//                    Thread.yield();
//                }
//                System.out.println("a= " + a);
//            }
//        });
//        t2.start();
//        t1.start();




        while(Thread.activeCount() > 2){
            //Thread.dumpStack();
            System.out.println("Thread.activeCount(): " + Thread.activeCount());
            Thread.yield();
        }

        System.out.println("result: " + vol);
    }

}
class DelayObj implements Delayed{
    private long delay = 0;//TimeUnit.NANOSECONDS
    public DelayObj(long delay, TimeUnit unit){
        this.delay = unit.toNanos(delay);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delay, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long r = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        if(r<0){
            return -1;
        }else if(r>0){
            return 1;
        }else{
            return 0;
        }
    }
}
