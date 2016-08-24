package top.tanghaibin.annotation;

import java.lang.annotation.*;

/**
 * Created by tanghaibin on 2016/8/24.
 *
 * 类注解
 */
@Documented//标注能被javadoc 工具处理
@Retention(RetentionPolicy.RUNTIME) //指定在什么时候有效：在此表示在运行时可以获得
@Target(ElementType.TYPE)//表示作用在什么类型上：类？方法？字段？构造方法？
public @interface ClassAnnotations {

    String name() default "小明";

    String age() default "21";
}
