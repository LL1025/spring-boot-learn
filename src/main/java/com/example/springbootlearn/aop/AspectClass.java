package com.example.springbootlearn.aop;

import com.example.springbootlearn.Do.UserDO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
@Slf4j
public class AspectClass {

    @Pointcut("execution(* com.example.springbootlearn.service.AopService..*(..))")
    private void pointCut() {
        log.info(String.format("aop的切入点"));
    }

    @Before("pointCut()")
    public void before() {
        log.info(String.format("前置同通知"));
    }

    @After("pointCut()")
    public void after() {
        log.info(String.format("后置通知"));
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info(String.format("完成通知"));
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AOP的around通知：方法执行前");
        ObjectMapper objectMapper = new ObjectMapper();
        Object[] args = joinPoint.getArgs();

        if (args != null && args.length > 0 && args[0] instanceof UserDO) {
            // 深度复制对象
            UserDO originalUser = (UserDO) args[0];
            UserDO userCopy = objectMapper.readValue(objectMapper.writeValueAsString(originalUser), UserDO.class);

            // 修改副本对象
            userCopy.setName("李四");
            userCopy.setAge(30);

            // 使用副本调用目标方法
            Object returnValue = joinPoint.proceed(new Object[]{userCopy});
            return returnValue;
        }

        return joinPoint.proceed(args);
    }
}
