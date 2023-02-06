package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 생성자 주입 시 final 키워드 사용 가능!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 역시 인터페이스(역할)에만 의존함!
    // 누군가 "주입"해주면 그것에 대해 로직만 실행하면 됨
    // MemoryMemberRepo + RateDiscountPolicy 가 주입된다.
    // @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    일반 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // For Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
