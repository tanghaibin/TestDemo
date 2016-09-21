package top.tanghaibin.jpa.entity;

import javax.persistence.*;

/**
 * Created by tanghaibin on 2016/9/21.
 */
@Entity(name = "t_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;
    @Column(name = "emp_name")
    private String name;
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dept_id",referencedColumnName = "dept_id")
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
