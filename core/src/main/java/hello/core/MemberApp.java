package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberServiceImpl이 들어있음
//        MemberService memberService = appConfig.memberService();

        // Spring Version
        // Context => 컨테이너라고 봐도 무방
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.find(1L);
        System.out.println("new : " + member.getName());
        System.out.println("find : " + findMember.getName());

    }
}
