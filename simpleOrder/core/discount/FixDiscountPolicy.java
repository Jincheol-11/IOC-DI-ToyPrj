package simpleOrder.core.discount;

import simpleOrder.core.member.Grade;
import simpleOrder.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    // VIP라면 할인 금액 1000, 아니라면 0
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
