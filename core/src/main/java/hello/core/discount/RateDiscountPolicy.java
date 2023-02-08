package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy // 문자열은 컴파일타임에 오류를 잡을 수 없어 어노테이션을 직접 만들어서 사용!
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRateAmount = 10; // 비율 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return (price * discountRateAmount) / 100;
        }else{
            return 0;
        }
    }
}
