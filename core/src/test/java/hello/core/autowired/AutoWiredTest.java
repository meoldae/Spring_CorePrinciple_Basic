package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        // 1. 의존 관계가 없으면 호출 자체가 안됨!
        @Autowired(required = false)
        public void setNoBean1(Member nobean1){
            System.out.println("nobean1 = " + nobean1);
        }

        // 2. 호출은 되지만 대상이 없다면 null 값이 입력된다.
        @Autowired
        public void setNoBean2(@Nullable Member nobean2){
            System.out.println("nobean2 = " + nobean2);
        }

        // 3. Spring Bean이 없으면 Optional.empty 타입으로 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> nobean3){
            System.out.println("nobean3 = " + nobean3);
        }
    }
}
