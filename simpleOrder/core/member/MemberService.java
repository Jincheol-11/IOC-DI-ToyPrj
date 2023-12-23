package simpleOrder.core.member;

public interface MemberService {

    // 회원가입
    public void join (Member member);

    // 멤버 찾기
    Member findMember (Long memberId);
}
