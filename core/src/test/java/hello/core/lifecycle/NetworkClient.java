package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 시작
    public void connect() {
        System.out.println("connect : " + url);
    }

    // 중간 동작
    public void call(String message) {
        System.out.println("call : " + url + "message = " + message);
    }

    // 종료
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // Property Set 이후 => 의존관계 주입 이후
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }


}
