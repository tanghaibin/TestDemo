package top.tanghaibin;

import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by tanghaibin on 2017/1/20.
 */
public class QueueDemo {

    public static Queue<String> queue = new LinkedBlockingDeque<String>();

    public QueueDemo() {
        queue.add("aa");
        queue.add("bb");
        queue.add("cc");
    }

    @Test
    public void test() {
//
//        new ReadThread().run();
//        new WriteThread().run();

        Queue<User> queue = new LinkedBlockingDeque<User>();
        queue.add(new User(1, "aa"));
        queue.add(new User(2, "bb"));

        queue.remove(new User(2, "bb"));
        for (User user : queue) {
            System.out.println(user);
        }

    }

    public class User {
        private Integer id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return Objects.equals(id, user.id);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
     public class ReadThread implements Runnable{

         public void run() {
             for (String s : queue) {
                 System.out.println(s + "\n");
                 System.out.println(Thread.currentThread().getName() + "读取数据线程休眠中");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }

         }
     }

    public class WriteThread implements Runnable{

        public void run() {
            for(int i = 0; i < 10; ++i) {
                System.out.println("写线程写数据中..");
                queue.add("data" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
