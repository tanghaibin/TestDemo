package top.tanghaibin.model;

/**
 * Created by tanghaibin on 2016/8/24.
 */
public class Department {

    private String name;
    private String count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Department(String name, String count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
