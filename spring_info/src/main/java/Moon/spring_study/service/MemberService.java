package Moon.spring_study.service;

import Moon.spring_study.domain.Member;
import Moon.spring_study.repository.MemberRepository;
import Moon.spring_study.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private final MemberRepository memberRepository;
//    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    //회원가입
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원 검증
        //위 검증 통과하면 저장
        memberRepository.save(member);
        return member.getId();

    }
    private void validateDuplicateMember(Member member){
        //임의의 규칙. 같은 이름이 있는 중복 회원은 안된다.
//        Optional<Member> result = memberRepository.findByName(member.getName()); //ctrl+alt+v 자동으로 반환
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        //null일 가능성이 있다면! Optional을 감싸서 반환 but 권장하지 않음. Optional 형태를 바로 꺼내서 뒤 코드와 연결해주는게 더 좋음.
        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
