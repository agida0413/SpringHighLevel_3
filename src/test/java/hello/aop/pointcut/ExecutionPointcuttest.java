package hello.aop.pointcut;

import hello.aop.aop.member.MemberService;
import hello.aop.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ExecutionPointcuttest {

    AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
     Method helloMethod;

     @BeforeEach
    public  void init() throws NoSuchMethodException{
         helloMethod= MemberServiceImpl.class.getMethod("hello",String.class);

     }

     @Test
    void pringmethod(){
         log.info("hellomethod={}",helloMethod);
     }

     @Test
    void exact(){
         aspectJExpressionPointcut.setExpression("execution(public String hello.aop.member.MemberServiceImpl.hello(String))");
         Assertions.assertThat(aspectJExpressionPointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
     }

     @Test
    void all(){
         aspectJExpressionPointcut.setExpression("execution(* *(..))");
         Assertions.assertThat(aspectJExpressionPointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
     }


}
