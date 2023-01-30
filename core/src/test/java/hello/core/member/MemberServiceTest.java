package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given -> 뭐가 주어진다.
        Member member = new Member(1L, "A", Grade.VIP);

        // when -> 주어졌을 때
        memberService.join(member);
        Member findMember = memberService.find(1L);

        // then -> 어떤 일이?
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
