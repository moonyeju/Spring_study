package Moon.spring_study.repository;

import Moon.spring_study.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() { //메서드가 실행 끝날 때마다 저장소(공용데이터)를 지움. -> 그래야 오류 없음.
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member=new Member();
        member.setName("Spring");

        repository.save(member);

        Member result=repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member memeber2 =new Member(); //shift + F6 하면 이름 한번에 바꿀 수 있음.
        memeber2.setName("spring2");
        repository.save(memeber2);

        Member result=repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 =new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member memeber2 =new Member();
        memeber2.setName("spring2");
        repository.save(memeber2);

        List<Member> result=repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
