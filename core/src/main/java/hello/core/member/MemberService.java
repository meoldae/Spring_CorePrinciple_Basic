package hello.core.member;

public interface MemberService {

    // 회원 관리
    void join(Member member);

    Member find(Long memberId);

}
