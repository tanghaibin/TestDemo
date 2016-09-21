package top.tanghaibin.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import top.tanghaibin.jpa.entity.Employee;

/**
 * Created by tanghaibin on 2016/9/21.
 */
public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
