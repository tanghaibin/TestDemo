package top.tanghaibin.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tanghaibin.jpa.dao.DepartmentDao;
import top.tanghaibin.jpa.entity.Department;

import java.util.Iterator;


/**
 * Created by tanghaibin on 2016/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springdata-jpa.xml")
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void findAll(){
        Iterable<Department> iterable = departmentDao.findAll();
        Iterator<Department> iterator = iterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void save(){
        Department department = new Department();
        department.setName("市场部");
        departmentDao.save(department);
    }
}
