package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    // DIP, OCP 위배
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // discountPolicy = new RateDiscountPolicy();

    // Interface만 ? => NullPointerException
    private DiscountPolicy discountPolicy;

    // 역시 인터페이스(역할)에만 의존함!
    // 누군가 "주입"해주면 그것에 대해 로직만 실행하면 됨
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
