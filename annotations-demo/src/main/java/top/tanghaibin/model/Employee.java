package top.tanghaibin.model;

import top.tanghaibin.annotation.AutoWaried;
import top.tanghaibin.annotation.ClassAnnotations;

/**
 * Created by zouhuixing on 2016/8/24.
 */
@ClassAnnotations(name="xiaogang",age = "52")
public class Employee {
    @AutoWaried
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                '}';
    }
}
