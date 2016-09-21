package top.tanghaibin.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import top.tanghaibin.jpa.entity.Department;

/**
 * Created by tanghaibin on 2016/9/21.
 */
public interface DepartmentDao extends CrudRepository<Department,Integer> {

}
