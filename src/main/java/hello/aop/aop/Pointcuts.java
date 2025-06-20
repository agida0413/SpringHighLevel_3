package hello.aop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder(){} //pointcut 시그니처

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    @Pointcut("allOrder() && allService()")
    public void allOrderAndService(){}
}
