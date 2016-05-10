package top.tanghaibin.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tangh on 2016/5/10.
 */
@ContextConfiguration("/applicationContext.xml")//用来配置spirng容器的来源；可以是类也可以是项目xml配置文件
@RunWith(SpringJUnit4ClassRunner.class)//启用spring对测试类的支持；用来标注此类是一个测试类
//@Transactional 注释标签是表明此测试类的事务启用，这样所有的测试方案都会自动的 rollback，即您不用自己清除自己所做的任何对数据库的变更了
public class DictionaryDaoTest {
    @Inject
    private DictionaryDao dictionaryDao;

    @Test
    public void testStringOption(){
        dictionaryDao.testStringOption("two","2");
    }
    @Test
    public void testListOption(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        User user = new User();
        user.setUsername("小明");
        user.setAge(21);
        user.setPswd("123");
        list.add(user);
        dictionaryDao.testListOption("testList",list);
    }
    @Test
    public void testSetOption(){
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        dictionaryDao.testSetOption("testSet",list);
    }
    @Test
    public void testOrderSetOption(){
        Map<Object,Integer> map = new HashMap<Object,Integer>();
        map.put("小明",21);
        map.put("小红",22);
        map.put("小刚",23);
        dictionaryDao.testOrderSetOption("testZset",map);
    }
    @Test
    public void testHashOption(){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("username","小明");
        map.put("age",21);
        map.put("pswd",123);
        dictionaryDao.testHashOption("testZset", map);
    }
}
