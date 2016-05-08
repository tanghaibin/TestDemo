package example;

import top.tanghaibin.HelloWorldService;

/**
 * Created by Administrator on 2016/2/18.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
    top.tanghaibin.HelloWorld service = new HelloWorldService().getHelloWorldPort();
    //invoke business method
    String result = service.sayHelloWorldFrom("china");
    System.out.println(result);
  }
}
