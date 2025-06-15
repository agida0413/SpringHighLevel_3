package hello.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j

public class AspectV5 {
    @Aspect
    @Component
    public static class LogAspect{
        @Around("hello.aop.order.aop.Pointcuts.allOrder()")
        public Object doLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
            log.info("[log] {}",proceedingJoinPoint.getSignature());
            return proceedingJoinPoint.proceed();
        }
    }
    @Aspect
    @Component
    public static class TxAspect{
        //hello.aop.order 패키지와 하위 패키지이면서 service
        @Around("hello.aop.order.aop.Pointcuts.allOrderAndService()")
        public Object doTransaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
            try {
                log.info("[트랜잭션 시작] {}",proceedingJoinPoint.getSignature());
                Object result =proceedingJoinPoint.proceed();
                log.info("[트랜잭션 커밋] {}",proceedingJoinPoint.getSignature());
                return result;
            } catch (Exception e) {
                log.info("[트랜잭션 롤백] {}",proceedingJoinPoint.getSignature());
                throw e;
            }
            finally {
                log.info("[리소스 릴리즈] {}",proceedingJoinPoint.getSignature());
            }


        }
    }


}
