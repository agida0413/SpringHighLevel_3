package hello.aop.aop;

import hello.aop.aop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class RetryAspect {

    @Around("@annotation(retry)")
    public Object doRetry(ProceedingJoinPoint joinPoint , Retry retry) throws Throwable{
        log.info("[retry] {} retry={}",joinPoint.getSignature(),retry);

        int maxRetry = retry.value();
        Exception exceptionHolder = null;
        for (int retrycount = 1; retrycount <= maxRetry ; retrycount++) {
            try {
                return joinPoint.proceed();
            } catch (Exception e) {
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;

    }
}
