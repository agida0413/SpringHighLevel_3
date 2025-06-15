package hello.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV2 {

    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder(){} //pointcut 시그니처
    @Around("allOrder()")
    public Object doLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("[log] {}",proceedingJoinPoint.getSignature());
        return proceedingJoinPoint.proceed();
    }
}
