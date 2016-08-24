package top.tanghaibin.app;

import top.tanghaibin.annotation.AutoWaried;
import top.tanghaibin.annotation.ClassAnnotations;
import top.tanghaibin.model.Department;
import top.tanghaibin.model.Employee;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tanghaibin on 2016/8/24.
 */
public class Main {

        public static void main(String [] args){
            /*********测试类注解************/
            Class<Employee> clazz = Employee.class;
            ClassAnnotations classAnnotations = clazz.getAnnotation(ClassAnnotations.class);
            String name = classAnnotations.name();
            String age = classAnnotations.age();
            System.out.println(name+":"+age);

            /***************测试自动注入注解*****************/
            Employee employee = new Employee();
            Class<Employee> employeeClass = (Class<Employee>) employee.getClass();
            Field[] fieldses = employeeClass.getDeclaredFields();

            Set<Object> set = new HashSet<>();
            set.add(new Department("研发部","25"));
            for(Field field:fieldses){
                if(field.isAnnotationPresent(AutoWaried.class)){
                    for(Object object : set){
                            if(field.getType().isAssignableFrom(object.getClass())) {
                                System.out.println("yes");
                                try {
                                    field.setAccessible(true);
                                    field.set(employee,object);
                                    System.out.println(employee);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }else{
                                System.out.println("no");
                            }
                    }
                }
            }
        }
}
