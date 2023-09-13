package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = discountPolicy.discount(member,itemPrice); //할인 조회 개인에 따라 등급만 던질지 전체를 던질지.
        //설계 잘한거. order서비스에서는 할인에 대해서 모름.
        //discountPolicy가 알아서 해줘 그러고 결과만 나한테 던져줘
        //단일 체계원칙 잘 지킴.
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
