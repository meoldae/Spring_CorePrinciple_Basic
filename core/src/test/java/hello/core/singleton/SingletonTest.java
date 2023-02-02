package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너 ")
    void puerContainer() {
        AppConfig appConfig = new AppConfig();
        // 조회 1 : 객체 생성
        MemberService memberService1 = appConfig.memberService();

        // 조회 2 : 객체 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 1과 2는 달라야 함!
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }
}