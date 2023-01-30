package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // MemberServiceImpl이 들어있음
        MemberService memberService = appConfig.memberService();
        // MemberService memberService = new MemberServiceImpl(appConfig.);
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.find(1L);
        System.out.println("new : " + member.getName());
        System.out.println("find : " + findMember.getName());
    }
}
