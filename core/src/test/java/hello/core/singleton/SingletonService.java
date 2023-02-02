package hello.core.singleton;

public class SingletonService {

    // 1. 정적변수는 단 하나. 클래스 로딩시 적재됨
    private static final SingletonService instance = new SingletonService();
    
    // 2. 정적 영역의 인스턴스 참조값을 반환함. ( 누가 몇 번을 하건 동일한 참조값 반환 )
    //    주의 : 객체 생성 불가하고 Class.getInstance() 로 사용!
    public static SingletonService getInstance(){
        return instance;
    }

    // 3. 생성자를 Private 으로 설정하여 외부에서 객체 인스턴스가 생성되지 못하도록 한다.
    private SingletonService() {}
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
