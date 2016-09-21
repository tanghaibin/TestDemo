package top.tanghaibin.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tanghaibin on 2016/9/21.
 */
@Entity(name="t_department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer id;
    @Column(name = "dept_name")
    private String name;
    @OneToMany(targetEntity = Employee.class,mappedBy = "department",fetch = FetchType.EAGER)
    private List<Employee> employeeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'';
    }
}
