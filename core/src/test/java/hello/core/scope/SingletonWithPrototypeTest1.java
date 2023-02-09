package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    public void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        bean1.addCount();
        assertThat(bean1.getCount()).isEqualTo(1);


        ac.close();
    }

    @Test
    public void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);

        ClientBean bean1 = ac.getBean(ClientBean.class);
        bean1.addCount();
        assertThat(bean1.getCount()).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        bean2.addCount();
        assertThat(bean2.getCount()).isEqualTo(2);
        /*
        ClientBean 은 Singleton 으로 관리되고, Client 안에 Prototype Bean(참조값)이 주입되어있기때문에 새 객체가 아니라
        먼저 주입한 객체의 주소가 남아있다.. 마치 싱글톤 객체처럼
        참고 : ClientBean 의 생성 시점에 PrototypeBean도 주입된다.
         */

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

    @Scope("singleton")
    static class ClientBean {

        private final PrototypeBean prototypeBean;

        @Autowired
        ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public void addCount(){
            prototypeBean.addCount();
        }

        public int getCount() {
            return prototypeBean.getCount();
        }
    }
}
