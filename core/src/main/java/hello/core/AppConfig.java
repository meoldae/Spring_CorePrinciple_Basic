package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
공연 기획자 같은 역할
애플리케이션의 전체 동작을 조정 및 운영
어떤 구현체(객체)를 주입할 지는 AppConfig에서 결정
 */
public class AppConfig {

    /*
    이전에는 MemberServiceImpl 안에서 직접 객체를 생성했음 ( 배우가 상대 배우를 직접 고르는 느낌 )
    "생성자"를 통해 객체를 만들어 "주입"
    각 Impl들은 본인 기능을 실행하는데에만 책임지면 된다!
     */
    public MemberService memberService(){
      return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
