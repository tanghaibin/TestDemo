package top.tanghaibin.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.tanghaibin.jpa.dao.EmployeeDao;
import top.tanghaibin.jpa.entity.Department;
import top.tanghaibin.jpa.entity.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public void findByExample(){

        Specification<Employee> specification = new Specification<Employee>() {
            List<Predicate> list = new ArrayList<Predicate>();
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                list.add(criteriaBuilder.between(root.get("id").as(Integer.class), 1, 3));
//                list.add(criteriaBuilder.equal(root.get("department").get("id").as(Integer.class),2));
                Predicate predicate =  criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
                Predicate predicate1 = criteriaBuilder.or(criteriaBuilder.equal(root.get("name").as(String.class), "小红"));

                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
                return criteriaBuilder.or(new Predicate[]{predicate, predicate1});
            }
        };

        System.out.println(employeeDao.findAll(specification));
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
