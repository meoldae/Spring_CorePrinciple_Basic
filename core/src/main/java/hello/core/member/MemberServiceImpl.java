package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemoryMemberRepository 구현체를 직접 선택 : 의존
    // 추상화 + 구현체 둘 모두에게 의존적임..
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member find(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
