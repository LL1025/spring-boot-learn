package com.example.springbootlearn.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.factory.ModelFactory;
import com.example.springbootlearn.factory.ModelFactoryCus;
import com.example.springbootlearn.jdbc.ThreadJdbc;
import com.example.springbootlearn.service.AopService;
import com.example.springbootlearn.service.MyBatisPlusService;
import com.example.springbootlearn.service.ThreadLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author linW2
 * @date 2024/9/14 11:55
 * @description TODO: 描述类的功能
 */
@RestController
@RequestMapping(value = "controller")
public class TestController {

    @Autowired
    private AopService aopService;
    @Autowired
    private ThreadLocalService threadLocalService;

    private final MyBatisPlusService myBatisPlusService;
    @Autowired
    private ModelFactoryCus modelFactoryCus;


    public TestController(MyBatisPlusService myBatisPlusService) {
        this.myBatisPlusService = myBatisPlusService;
    }

    @PostMapping("/aop/test")
    public void aopTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        aopService.testAop(userDO);
    }

    @PostMapping("/threadLocal/test")
    public JSONObject threadLocalTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        return threadLocalService.testThreadLocal(userDO);
    }

    @PostMapping("/mybatisPlus/test")
    public void mybatisPlusTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        myBatisPlusService.inserUserAndClass();
    }

    @PostMapping("/model/test")
    public void modelTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() ->{
            ModelFactory.getModelService("modelAServiceImpl").sendReturn("策略A");
        });
        Thread.sleep(5000);
        executorService.submit(() ->{
            ModelFactory.getModelService("modelBServiceImpl").sendReturn("策略B");
        });
    }

    @PostMapping("/abstract/model/test")
    public void abstractModelTest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() ->{
            modelFactoryCus.getModelFactory("modelAServiceImpl").sendReturn("AAAAAA");
        });
        Thread.sleep(5000);
        executorService.submit(() ->{
            modelFactoryCus.getModelFactory("modelBServiceImpl").sendReturn("BBBBBB");
        });
    }
    public static void main(String[] args) {
//        Connection connection = ThreadJdbc.getConnection();
//        if (connection != null) {
//            System.out.println("数据库连接成功");
//            ThreadJdbc.closeConnection();
//        }

        //创建一个对象
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        //创建一个虚引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<UserDO> phantomReference = new PhantomReference<>(userDO, referenceQueue);

        //强引用
        UserDO userDO1 = new UserDO();
        userDO1.setUserAge(18);
        System.out.println(userDO1);

        //弱引用
        WeakReference<UserDO> weakReference = new WeakReference<>(userDO);

        //软引用
        SoftReference<UserDO> softReference = new SoftReference<>(userDO);

        //此时对象还未被回收，我们可以用强引用访问对象
        System.out.println("强引用：" + userDO.getUserAge());


        //因为上面使用的强引用进行访问对象，现在需要取消强引用，才能被GC
        userDO = null;
        //对对象进行GC操作
        System.gc();

        //再次使用强引用访问对象的时候，应该时访问不到才对
//        System.out.println("取消强引用后" + userDO.getUserAge());

        try {
            // 从引用队列中获取虚引用
            PhantomReference<Object> removedReference = (PhantomReference<Object>) referenceQueue.remove();
            if (removedReference!= null) {
                System.out.println("Object has been garbage collected.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
