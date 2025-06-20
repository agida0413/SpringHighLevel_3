package hello.aop.exam;

import hello.aop.aop.RetryAspect;
import hello.aop.aop.TraceAspect;
import hello.aop.aop.exam.ExamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({TraceAspect.class, RetryAspect.class})
public class ExamTest {

    @Autowired
    ExamService examService;

    @Test
    void test(){
        for (int i = 0; i < 5; i++) {
            examService.request("data"+i);
        }
    }
}
