package simpleOrder.core.member;

public class MemberServiceImpl implements MemberService{

    // 얘를 참조
    private final MemberRepository memberRepository;

    // 주입 받을 생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 멤버를 받아와서 멤버 레포지토리의 세이브 메소드에서 멤버 호출해서 저장
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    //멤버 아이디 받아와서 멤버레포지토리의 아이디찾기 메서드에서 멤버 아이디 조회
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
