package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRateAmount = 20; // 비율 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return (price * discountRateAmount) / 100;
        }else{
            return 0;
        }
    }
}
