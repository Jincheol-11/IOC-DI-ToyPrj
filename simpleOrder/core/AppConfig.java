package simpleOrder.core;

import simpleOrder.core.discount.DiscountPolicy;
import simpleOrder.core.discount.RateDiscountPolicy;
import simpleOrder.core.member.MemberRepository;
import simpleOrder.core.member.MemberService;
import simpleOrder.core.member.MemberServiceImpl;
import simpleOrder.core.member.MemoryMemberRepository;
import simpleOrder.core.order.OrderService;
import simpleOrder.core.order.OrderServiceImpl;

// 해당 서비스와 레포지토리들이 기능에만 충실할 수 있도록 여기서 기능 조정해줌
// 즉 구현 객체를 생성하고 연결하는 책임자 + 중복 제거
// DI 컨테이너
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 멤버 레포지토리에서 MemoryMemberRepository 반환해옴
    // 동적인 클래스 DI
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 정액할인 정책 반환
    // 만약 정액 및 정률정책 중 한줄만 고치면 원하는 정책을 쓸 수 있게 된다.
    // 동적인 클래스 DI
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
