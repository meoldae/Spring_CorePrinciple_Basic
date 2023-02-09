package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

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
        assertThat(bean1.pureLogic()).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        assertThat(bean2.pureLogic()).isEqualTo(2);
        /*
        ClientBean 은 Singleton 으로 관리되고, Client 안에 Prototype Bean(참조값)이 주입되어있기때문에 새 객체가 아니라
        먼저 주입한 객체의 주소가 남아있다.. 마치 싱글톤 객체처럼
        참고 : ClientBean 의 생성 시점에 PrototypeBean도 주입된다.
         */
    }

    @Test
    public void PrototypeInSingletonUseProvider1() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);

        ClientBean bean1 = ac.getBean(ClientBean.class);
        assertThat(bean1.providerLogic1()).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        assertThat(bean2.providerLogic1()).isEqualTo(1);
    }

    @Test
    public void PrototypeInSingletonUseProvider2() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, ClientBean.class);

        ClientBean bean1 = ac.getBean(ClientBean.class);
        assertThat(bean1.providerLogic2()).isEqualTo(1);

        ClientBean bean2 = ac.getBean(ClientBean.class);
        assertThat(bean2.providerLogic2()).isEqualTo(1);
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

        @Autowired
        private PrototypeBean prototypeBean;

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider1;

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider2;

        public int pureLogic(){
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

        public int providerLogic1() {
            PrototypeBean prototypeBean = prototypeBeanProvider1.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

        public int providerLogic2() {
            PrototypeBean prototypeBean = prototypeBeanProvider2.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }
}
