package hello.aop.aop.exam;

import hello.aop.aop.exam.annotation.Retry;
import hello.aop.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;
    @Trace
    @Retry
    public String save(String itemId){
        seq++;
        if(seq%5 ==0 ){
            throw new IllegalStateException("예외발생");
        }

        return "ok";
    }
}
