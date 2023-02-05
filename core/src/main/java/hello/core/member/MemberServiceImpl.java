package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // MemoryMemberRepository 구현체를 직접 선택 : 의존
    // 추상화 + 구현체 둘 모두에게 의존적임..
    private final MemberRepository memberRepository;

    // MemoryMemberRepository라는 말은 어디에도 없다!
    // 인터페이스(역할)에만 의존! 어떤 Repository가 들어올 지 모른다.
    @Autowired
    // Autowired 주석이 있는 생성자에 알아서 맞는 타입의 컴포넌트를 주입한다.
    // 현재의 경우 @Component가 붙어있는 MemoryMemberRepository가 주입된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member find(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // For Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
