package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService=new MemberServiceImpl();

        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = (MemberService) applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); //id Long type이라 L붙여줌 안 붙이면 오류남
        memberService.join(member);

        Member findMember=memberService.findMember(1L);
        System.out.println("new member: "+member.getName());
        System.out.println("find member: "+findMember.getName());

    }
}
