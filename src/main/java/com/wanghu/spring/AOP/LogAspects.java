package com.wanghu.spring.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author wanghu
 * @date 2021/12/20 18:40
 *
 * @Aspect :告诉Spring当前类是一个切面类
 *
 * JoinPoint joinPoint必选出现在参数第一，否则无法使用
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1.本类引用
    @Pointcut("execution(public  int com.wanghu.spring.AOP.MathCalculator.*(..)))")
    public void pointcut(){}

    //@Before 在目标方法之前切入；切入点表达式（指定在那个方法切入）
    @Before(" pointcut()")
    public void logStart(JoinPoint joinPoint){
        Object [] args=joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"前置通知....除法运行........参数列表是：{"+Arrays.asList(args)+"}");
    }

    @After(" com.wanghu.spring.AOP.LogAspects.pointcut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"后置通知.....除法结束........");
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object  result){
        System.out.println(""+joinPoint.getSignature().getName()+"返回通知......除法正常返回........运行结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointcut() ",throwing = "exception")
    public void logExpection(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常通知......除法异常..........异常返回信息：{"+exception+"}");
    }
}
