package com.enjoyican.ward;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author Administrator
 * @version v1.1
 * @since 2021/1/19 15:46
 */
public class Ward {

    public static void main(String[] args) {


        String xmlResourcePath = "classpath:bean-lifecyle-ward.xml";
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(xmlResourcePath);
        User user = ac.getBean(User.class);
        System.out.println(user);
        System.out.println();
        // 关闭销毁
        ac.registerShutdownHook();
        ac.close();
        System.gc();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }
}