package com.gy.di;

/**
 * Created by hello on 2018/3/20.
 */
public class TestServiceImpl {

    public TestObject3 TestObject3;
    public com.gy.di.TestObject1 TestObject1;

    // 字段上的注解,可以配置name属性
    @ZxfResource
    public com.gy.di.TestObject2 TestObject2;

    // set方法上的注解，带有name属性
    @ZxfResource(name = "TestObject3")
    public void setUserDao(TestObject3 TestObject3) {
        this.TestObject3 = TestObject3;
    }

    // set方法上的注解，没有配置name属性
    @ZxfResource
    public void setUser1Dao(com.gy.di.TestObject1 TestObject1) {
        this.TestObject1 = TestObject1;
    }

    public void show() {

        TestObject1.show1();
        TestObject2.show2();
        TestObject3.show();

        System.out.println("调用了TestService方法........");

    }

    public static void main(String[] args) {
        ClassPathXMLApplicationContext path = new ClassPathXMLApplicationContext(
                "beans.xml");
        TestServiceImpl userService =(TestServiceImpl)path.getBean("TestService");
        userService.show();
    }
}
