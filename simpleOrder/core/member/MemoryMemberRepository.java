package simpleOrder.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    public static Map<Long, Member> store = new HashMap<>();

    // 회원 저장 메서드 vo에서 ID를 받아와 key, 멤버라는 값으로 저장함
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    // 아이디찾기 메서드
    //멤버인덱스를 전달받아서 그 멤버인덱스에 대한 정보를 반환
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
