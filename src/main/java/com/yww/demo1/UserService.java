package com.yww.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Spring的Bean管理的注解方式:
 *  * 传统方式需要去XMl中配置<bean id = "" class=""></bean>
 *  而注解方式只需如下操作:
 */
@Service("userService")
public class UserService {
    @Value("shaBi")
    private String name;

    //默认按类型进行注入,如果存在两个相同Bean类型,则按照名称注入
    //可以使用@Autowired的required属性,设置一定要找到匹配的Bean
    /*@Autowired
    @Qualifier("userDao")*/
    @Resource(name = "userDao")
    private UserDao userDao;



    public String sayHello(String name){
        return "Hello"+name;
    }
    public String recommend(){
        return "My name is" + name;
    }


    public void save(){
        System.out.println("Service中保存方法...");
        userDao.save();  //因为直接注入了,所以就不再需要再次实例化
    }
}
