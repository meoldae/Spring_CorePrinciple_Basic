package hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
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
}
