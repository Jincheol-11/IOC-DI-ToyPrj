package simpleOrder.core.order;

import simpleOrder.core.discount.DiscountPolicy;
import simpleOrder.core.member.Member;
import simpleOrder.core.member.MemberRepository;

// 정적인 클래스 DI
public class OrderServiceImpl implements OrderService{

    // 아래의 두 메서드 참조
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // 주입받을 생성자
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 세개의 변수를 사용하고, 멤버id 정보를 member에 저장
    // 그 후 그 멤버와 아이템 가격을 활용하여 할인가격 책정
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
