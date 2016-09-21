package top.tanghaibin.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tanghaibin.jpa.dao.EmployeeDao;
import top.tanghaibin.jpa.entity.Department;
import top.tanghaibin.jpa.entity.Employee;

import java.util.Iterator;

/**
 * Created by tanghaibin on 2016/9/21.
 */
@ContextConfiguration("/springdata-jpa.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findAll(){

        Iterable<Employee> iterable = employeeDao.findAll();
        Iterator<Employee> iterator = iterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void save(){
        Employee employee = new Employee();
        employee.setName("小红");
        Department department = new Department();
        department.setId(2);
        employee.setDepartment(department);
        employeeDao.save(employee);
    }
}
