package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
공연 기획자 같은 역할
애플리케이션의 전체 동작을 조정 및 운영
어떤 구현체(객체)를 주입할 지는 AppConfig에서 결정
 */
@Configuration
public class AppConfig {

    /*
    이전에는 MemberServiceImpl 안에서 직접 객체를 생성했음 ( 배우가 상대 배우를 직접 고르는 느낌 )
    "생성자"를 통해 객체를 만들어 "주입"
    각 Impl들은 본인 기능을 실행하는데에만 책임지면 된다! -> SRP 성립
    구성 영역과 사용 영역의 분리
     */

    /*
    중복 부분을 제거 + 다른 구현체로 변경할 때 한 부분만 변경하면 된다.
    역할과 구현 클래스가 한번에 들어온다. 
        멤버 리포지토리는 ? 메모리 리포지토리를 사용하는구나
        할인 정책은 ?  고정할인 정책을 사용하는구나
     */
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    // 단 한줄 변경함으로서 정책 변경이 가능해졌다.
    // 사용 영역의 코드는 전혀 손댈 필요 없다. -> OCP 성립 ( 확장에는 열려있되, 사용영역의 코드 변경은 닫혀있음 )
    @Bean
    public DiscountPolicy discountPolicy(){
    // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    /*
    의존관계 주입을 통해 구현체에 의존하는것이 아니라 추상화(인터페이스), 역할에 의존하게 되었다.
    -> DIP 성립!
     */
    @Bean
    public MemberService memberService(){
      return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }



}
