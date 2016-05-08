package top.tanghaibin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2016/1/28.
 */
public class ExcutorDemo {
    /*创建定长的线程池；可控制*/
    //ExecutorService executorService = Executors.newFixedThreadPool(7);
    /*带缓存的线程池；线程池长度超过处理需要；可灵活回收线程；如果没有可回收线程；则新建线程来处理；线程池为无限大；当第一个任务完成后；会回收此线程供下一个任务使用*/
    ExecutorService executorService = Executors.newCachedThreadPool();
    public List<Callable<Runnable>> setTask() {
        //,"E:\\win10壁纸\\1453776252238.jpg","E:\\win10壁纸\\1453776291293.jpg"
        List<Callable<Runnable>> list = new ArrayList<Callable<Runnable>>();
        String[] filepath = {"D:\\jboss-as-web-7.0.2.Final.zip", "D:\\jboss-as-web-7.0.2.Final.zip","D:\\jboss-as-web-7.0.2.Final.zip","D:\\jboss-as-web-7.0.2.Final.zip","D:\\jboss-as-web-7.0.2.Final.zip","D:\\jboss-as-web-7.0.2.Final.zip"};
        for (String path : filepath) {
            File file = new File(path);
            list.add(new MyCallable(file));
        }
        return list;
    }

    public void execute() {
        List<Callable<Runnable>> list = setTask();
        try {
            List<Future<Runnable>> futures = executorService.invokeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /******************************************************/
    public static void main(String[] args) {
        new ExcutorDemo().execute();
        File [] files = new File[6];
        files[0] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        files[1] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        files[2] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        files[3] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        files[4] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        files[5] = new File("D:\\jboss-as-web-7.0.2.Final.zip");
        new TestOutput(files).out();
    }
}

class TestOutput {
    File[] file = null;
    public TestOutput(File[] file) {
        this.file = file;
    }

    public void out() {
       new Thread(){
           @Override
           public void run() {
               for (int i = 0; i < file.length; ++i) {
                   try {
                       OutputStream outputStream = new FileOutputStream(new File("E:/testexecutor/" + "单线程" + UUID.randomUUID() + ".jpg"));
                       InputStream inputStream = new FileInputStream(file[i]);
                       byte[] buf = new byte[1024];
                       int len = 0;
                       while ((len = inputStream.read(buf)) != -1) {
                           outputStream.write(buf);
                       }
                       System.out.println("单线程传输完毕...");
                       outputStream.close();
                       inputStream.close();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
       }.start();

    }
}

    class MyCallable implements Callable<Runnable> {
        File file = null;
        public MyCallable(File file) {
            this.file = file;
        }
        @Override
        public Runnable call() throws Exception {
            Runnable runnable =  new Runnable() {
                @Override
                public void run() {
                    try {
                        OutputStream outputStream = new FileOutputStream(new File("E:/testexecutor/" + UUID.randomUUID() + ".jpg"));
                        InputStream inputStream = new FileInputStream(file);
                        byte[] buf = new byte[1024];
                        int len = 0;
                        while ((len = inputStream.read(buf)) != -1) {
                            outputStream.write(buf);
                        }
                        System.out.println("多线程传输完毕...");
                        outputStream.close();
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            runnable.run();
            return runnable;
        }
    }
