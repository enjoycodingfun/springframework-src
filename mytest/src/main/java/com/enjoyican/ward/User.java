package com.enjoyican.ward;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * TODO
 *
 * @author Administrator
 * @version v1.1
 * @since 2021/1/19 15:44
 */
//@Component
public class User implements DisposableBean, InitializingBean, BeanNameAware {

    static {
        System.out.println("static 代码块");
    }

    static void comon(){
        System.out.println("static 方法");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    private int id;

    private String name;

    private String beanName;

    public User() {
        System.out.println("无参构造方法：  User 被实例化");
    }


    /**
     * 构造方法执行后，初始化，
     */
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct");
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName()设置：" + name);
        this.name = name;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName");
        this.beanName = beanName;
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy....");
    }

    public void start() {
        System.out.println("init-method:自定义初始化的方法....");
    }

    public void end() {
        System.out.println("destroy-method:自定义销毁的方法....");
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", beanName=" + beanName + "]";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口destroy方法：销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean接口afterPropertiesSet方法");
    }
}